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
				billSubTotal += Double.parseDouble(movie.get(0).get(5));
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
			billSubTotal += Double.parseDouble(movie.get(0).get(5));
		}
		
		this.billTotal = billSubTotal;
		
		if (billTotal > 0) {
			message += "\n\nYour subtotal is: " + billTotal + "\n";
			
			message += this.getCredit();
		}else {
			message += "\n\nAll reserved tickets have been paid for.\n";
		}
		
		return message;
	}
	
	public String payBill() {
		if (billTotal > 0) {
			if (ticketID.isEmpty()) {
				ArrayList<ArrayList<String>> emailTickets = myConnection
						.doRetrievalQuery("SELECT TicketID FROM TICKET WHERE Email = \"" + email + "\" AND Status <> 'paid'");

				for (int i = 0; i < emailTickets.size(); i++)
					myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", emailTickets.get(i).get(0));

			}
			else {
				myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", ticketID);
			}
			
			this.applyCredit();

			return "Tickets and receipt have been sent to your email.";
		}else {
			return "You can view your already purchased tickets in the ticket window.";
		}
	}
	
	public String getCredit() {
		
		ArrayList<ArrayList<String>> currentUserCredits = myConnection
				.doRetrievalQuery("SELECT * FROM MOVIECREDIT WHERE Email = \"" + email + "\"");
		
		if (!currentUserCredits.isEmpty()) {
			
			double billDisplay = getBillTotal();
			
			for (int i = 0; i < currentUserCredits.size(); i++)
				if (billDisplay >= Double.parseDouble(currentUserCredits.get(i).get(2))) {
					billDisplay -= Double.parseDouble(currentUserCredits.get(i).get(2));
				}
			String s = "Ticket credit for " + email + " has been applied:\n";
			s += "Subtotal after credit: $" + billDisplay + "\n";
			return s;
		}
		else {
			return "";
		}
	}
	
	public void applyCredit() {
		
		ArrayList<ArrayList<String>> currentUserCredits = myConnection
				.doRetrievalQuery("SELECT * FROM MOVIECREDIT WHERE Email = \"" + email + "\"");
		
		if (!currentUserCredits.isEmpty()) {
			for (int i = 0; i < currentUserCredits.size(); i++)
				if (this.getBillTotal() >= Double.parseDouble(currentUserCredits.get(i).get(2))) {
					this.setBillTotal(this.getBillTotal()-Double.parseDouble(currentUserCredits.get(i).get(2)));
					myConnection.doDeleteQuery("MOVIECREDIT", "MovieCreditID", currentUserCredits.get(i).get(0));
				}
		}
	}

	public double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}
	
}
