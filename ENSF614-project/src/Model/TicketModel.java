package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import JDBC.SqlDatabaseConnection;

public class TicketModel {

	SqlDatabaseConnection myConnection;
	String email;
	SeatModel seat;

	public TicketModel() throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}

	public String getTicketInfo(String email, String ticketId) {

		String allTickets = "";

		if (ticketId.isEmpty()) {
			allTickets = "Tickets currently reserved for: " + email + "\n\n";

			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE Email = \"" + email + "\"");

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
			allTickets = "Ticket ID #" + ticketId + "\n\n";

			ArrayList<ArrayList<String>> emailTickets = myConnection.doRetrievalQuery(
					"SELECT * FROM TICKET WHERE Email = \"" + email + "\" AND TicketID = \"" + ticketId + "\"");
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

	public String cancelTicket(String email, String ticketId) {
		String message = "";
		
		ArrayList<ArrayList<String>> emailTickets = myConnection
				.doRetrievalQuery("SELECT * FROM TICKET WHERE TicketID = \"" + ticketId + "\"");
		ArrayList<ArrayList<String>> seats = myConnection
				.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(0).get(1) + "\"");
		ArrayList<ArrayList<String>> movie = myConnection
				.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date movieDateTime = new java.util.Date();
		try {
			movieDateTime = dateFormatter.parse(movie.get(0).get(3) + " " + movie.get(0).get(4));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date now = new java.util.Date();
		
		long hoursUntilMovie = (movieDateTime.getTime() - now.getTime())*3600000;

		if (email.isEmpty() || ticketId.isEmpty()) {
			message = "Please enter both your email and an individual ticket ID";
		}
		else if(hoursUntilMovie < 72) {
			message = "You cannot cancel your ticket within 72 hours of the showtime.";
		}
		else {
			if (emailTickets.isEmpty()) {
				return "Ticket ID# " + ticketId + " does not exist.";
			}
			boolean cancelledTicket = myConnection.doDeleteQuery("TICKET", "TicketID", ticketId);
			if (cancelledTicket && emailTickets.get(0).get(2).equals("paid")) {
				
				double creditAmount;
				
				ArrayList<ArrayList<String>> registeredUser = myConnection
						.doRetrievalQuery("SELECT * FROM REGISTEREDUSER WHERE Email = \"" + email + "\"");
				
				if (registeredUser.isEmpty()) {
					creditAmount = Double.parseDouble(movie.get(0).get(5)) * 0.85;
				}else {
					creditAmount = Double.parseDouble(movie.get(0).get(5));
				}
				
				
				ArrayList<String> credit = new ArrayList<String>();
				credit.add(email);
				credit.add(String.valueOf(creditAmount));
				
				myConnection.doInsertQuery("MOVIECREDIT (Email, Amount)", credit);
				
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
