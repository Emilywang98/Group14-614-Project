package Model;

import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class PaymentModel {
	
	SqlDatabaseConnection myConnection;
	String email;
	String ticketID;
	double billTotal;
	
	public PaymentModel(String email, String ticketID) throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
		this.email = email;
		this.ticketID = ticketID;
	}
	
	public String calculateTotalBill() {
		double billSubTotal = 0;
		String message = "Outstanding tickets reserved by: " + email + "\nFor the following ticket(s): ";
		
		if (ticketID.isEmpty()) {
			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE Email = \"" + email + "\" AND Status <> 'paid'");
	
			for (int i = 0; i < emailTickets.size(); i++) {
				message += "\t" + emailTickets.get(i).get(0);
				ArrayList<ArrayList<String>> seats = myConnection
						.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(i).get(1) + "\"");
				ArrayList<ArrayList<String>> movie = myConnection
						.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
				billSubTotal += Double.parseDouble(movie.get(0).get(6));
			}
		}
		else {
			ArrayList<ArrayList<String>> emailTicket = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE TicketID = \"" + ticketID + "\" AND Status <> 'paid'");
			
			message += "\t" + emailTicket.get(0).get(0);
			
			ArrayList<ArrayList<String>> seats = myConnection
					.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTicket.get(0).get(1) + "\"");
			ArrayList<ArrayList<String>> movie = myConnection
					.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
			billSubTotal += Double.parseDouble(movie.get(0).get(6));
		}
		
		this.billTotal = billSubTotal;
		
		message += "\nYour subtotal is: " + billSubTotal;
		
		return message;
	}
	
	public String payBill() {
		
		if (ticketID.isEmpty()) {
			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT TicketID FROM TICKET WHERE Email = \"" + email + "\" AND Status <> 'paid'");
			
			for (int i = 0; i < emailTickets.size(); i++)
				myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", emailTickets.get(i).get(0));
	
		}
		else {
			myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", ticketID);
		}
		
		return "Tickets and receipt have been sent to your email.";
	}

	public double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}
	
}
