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
				allTickets += movie.get(0).get(5) + " " + movie.get(0).get(2) + ", " + movie.get(0).get(4) + "\n";
				allTickets += "Row: " + seats.get(0).get(2) + "    Seat column: " + seats.get(0).get(3) + "\n\n";
				allTickets += "Ticket Price: " + movie.get(0).get(6) + "\n";
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
			allTickets += movie.get(0).get(5) + " " + movie.get(0).get(2) + ", " + movie.get(0).get(4) + "\n";
			allTickets += "Row: " + seats.get(0).get(2) + "    Seat column: " + seats.get(0).get(3) + "\n\n";
			allTickets += "Ticket Price: " + movie.get(0).get(6) + "\n";
			allTickets += "Ticket Paid: " + emailTickets.get(0).get(2) + "\n\n";
			allTickets += "Ticket ID number: " + emailTickets.get(0).get(0) + "\n";
			allTickets += "---------------\n\n";

		}

		return allTickets;
	}

//	public void addTicket() {
//		
//	}

	public void cancelTicket() {

	}
}
