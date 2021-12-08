package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import JDBC.SqlDatabaseConnection;

/**
 * TicketModel handles the different states of a ticket object. The class handles retrieving the ticket info and
 * canceling tickets.
 * 
 * @author Greg
 *
 */
public class TicketModel {

	SqlDatabaseConnection myConnection;
	String email;
	SeatModel seat;

	public TicketModel() throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}
	
	
	/**
	 * getTicketInfo method uses the entered emailed and optionally entered ticket ID to find the tickets 
	 * associated with that user.
	 * 
	 */
	public String getTicketInfo(String email, String ticketId) {

		String allTickets = "";

		if (ticketId.isEmpty()) {
			allTickets = "Tickets currently reserved for: " + email + "\n\n";

			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE Email = \"" + email + "\"");
			
			// Ticket info is pulled for each ticket associated with the current user
			for (int i = 0; i < emailTickets.size(); i++) {
				ArrayList<ArrayList<String>> seats = myConnection
						.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(i).get(1) + "\"");
				ArrayList<ArrayList<String>> movie = myConnection
						.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");

				allTickets += movie.get(0).get(1) + "\n";
				allTickets += movie.get(0).get(4) + " " + movie.get(0).get(2) + ", " + movie.get(0).get(3) + "\n";
				allTickets += "Row: " + seats.get(0).get(2) + "    Seat column: " + seats.get(0).get(3) + "\n\n";
				allTickets += "Ticket Price: $" + movie.get(0).get(5) + "\n";
				allTickets += "Ticket Paid: " + emailTickets.get(i).get(2) + "\n\n";
				allTickets += "Ticket ID number: " + emailTickets.get(i).get(0) + "\n";
				allTickets += "---------------\n\n";
			}
		} else {
			// Ticket info is pulled for the individual ticket
			
			allTickets = "Ticket ID #" + ticketId + "\n\n";

			ArrayList<ArrayList<String>> emailTickets = myConnection.doRetrievalQuery(
					"SELECT * FROM TICKET WHERE Email = \"" + email + "\" AND TicketID = \"" + ticketId + "\"");
			
			// here we check to see if that ticket is in the DB
			if (!emailTickets.isEmpty()) {
				ArrayList<ArrayList<String>> seats = myConnection
						.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(0).get(1) + "\"");
				ArrayList<ArrayList<String>> movie = myConnection
						.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
	
				allTickets += movie.get(0).get(1) + "\n";
				allTickets += movie.get(0).get(4) + " " + movie.get(0).get(2) + ", " + movie.get(0).get(3) + "\n";
				allTickets += "Row: " + seats.get(0).get(2) + "    Seat column: " + seats.get(0).get(3) + "\n\n";
				allTickets += "Ticket Price: " + movie.get(0).get(5) + "\n";
				allTickets += "Ticket Paid: " + emailTickets.get(0).get(2) + "\n\n";
				allTickets += "Ticket ID number: " + emailTickets.get(0).get(0) + "\n";
				allTickets += "---------------\n\n";
			}else {
				allTickets = "There is no matching ticket for that email.";
			}

		}

		return allTickets;
	}

//	public void addTicket() {
//		
//	}

	/**
	 * cancelTicket method handles canceling of tickets and applying credits to that user by email.
	 * Registered users retrieve a 100% credit, ordinary users only 85%.
	 * 
	 */
	public String cancelTicket(String email, String ticketId) {
		String message = "";
		
		
		
		ArrayList<ArrayList<String>> emailTickets = myConnection
				.doRetrievalQuery("SELECT * FROM TICKET WHERE TicketID = \"" + ticketId + "\"");
		ArrayList<ArrayList<String>> seats = myConnection
				.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(0).get(1) + "\"");
		ArrayList<ArrayList<String>> movie = myConnection
				.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
		
		// user is only allowed to cancel if its more than 72 hours away from the current show
		SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date movieDateTime = new java.util.Date();
		try {
			movieDateTime = dateTimeFormatter.parse(movie.get(0).get(3) + " " + movie.get(0).get(4));
		} catch (ParseException e) {
			System.err.println("entered date is not in correct format yyyy-MM-dd HH:mm");
		}
		Date now = new java.util.Date();
		
		long hoursUntilMovie = (movieDateTime.getTime() - now.getTime())*3600000;
		
		// making sure both email and ticketId are entered to actually be able to cancel
		if (email.isEmpty() || ticketId.isEmpty()) {
			message = "Please enter both your email and an individual ticket ID";
		}
		// making sure they arent trying to cancel within 72 hours of the movie
		else if(hoursUntilMovie < 72) {
			message = "You cannot cancel your ticket within 72 hours of the showtime.";
		}
		else {
			if (emailTickets.isEmpty()) {
				return "Ticket ID# " + ticketId + " does not exist.";
			}
			
			//deleting the ticket from the database
			boolean cancelledTicket = myConnection.doDeleteQuery("TICKET", "TicketID", ticketId);
			if (cancelledTicket && emailTickets.get(0).get(2).equals("paid")) {
				
				// creating credit in the database
				
				double creditAmount;
				
				ArrayList<ArrayList<String>> registeredUser = myConnection
						.doRetrievalQuery("SELECT * FROM REGISTEREDUSER WHERE Email = \"" + email + "\"");
				
				// setting refund to 85% for ordinary users
				
				if (registeredUser.isEmpty()) {
					creditAmount = Double.parseDouble(movie.get(0).get(5)) * 0.85;
				}else {
					creditAmount = Double.parseDouble(movie.get(0).get(5));
				}
				
				
				ArrayList<String> credit = new ArrayList<String>();
				credit.add(email);
				credit.add(String.valueOf(creditAmount));
				
				// adding on year for the expiry date
				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.YEAR, 1);
				Date expiry = c.getTime();
				
				credit.add(dateFormatter.format(expiry));
				
				myConnection.doInsertQuery("MOVIECREDIT (Email, Amount, Expiry)", credit);
				
				message = "Ticket ID #" + ticketId + " has been cancelled.";
				message += "\nEmail: " + email + " has been credited.";
			}else if (cancelledTicket && !emailTickets.get(0).get(2).equals("paid")) {
				message = "Ticket ID #" + ticketId + " has been cancelled.";
			}
			else {
				message = "Unable to cancel ticket ID #" + ticketId;
			}
		}
		
		return message;
	}
}
