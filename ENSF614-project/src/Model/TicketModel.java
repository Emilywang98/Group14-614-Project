package Model;

import java.util.ArrayList;

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

		}

		return allTickets;
	}

//	public void addTicket() {
//		
//	}

	public String cancelTicket(String email, String ticketId) {
		String message = "";

		if (email.isEmpty() || ticketId.isEmpty()) {
			message = "Please enter both your email and an individual ticket ID";
		}
		else {
			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE TicketID = \"" + ticketId + "\"");
			if (emailTickets.isEmpty()) {
				return "Ticket ID# " + ticketId + " does not exist.";
			}
			boolean cancelledTicket = myConnection.doDeleteQuery("TICKET", "TicketID", ticketId);
			if (cancelledTicket && emailTickets.get(0).get(2).equals("paid")) {
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
