package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import JDBC.SqlDatabaseConnection;

/**
 * PaymentModel class retrieves email and ticket information from the controller to process the payments.
 * 
 * @author Greg
 *
 */
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
	
	/**
	 * calculateTotalBill method pulls the ticket or tickets associated with that email and returns the
	 * total amount to the controller, to be displayed on the view.
	 * 
	 */
	public String calculateTotalBill() {
		double billSubTotal = 0;
		String message = "Outstanding tickets reserved by: " + email + "\nFor the following ticket(s): ";
		
		// if user didn't enter a ticket ID, it grabs all of their outstanding tickets and information
		if (ticketID.isEmpty()) {
			ArrayList<ArrayList<String>> emailTickets = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE Email = \"" + email + "\" AND Status <> 'paid'");
			
			// grabbing information for all tickets and totaling the cost
			for (int i = 0; i < emailTickets.size(); i++) {
				message += "\t" + emailTickets.get(i).get(0);
				ArrayList<ArrayList<String>> seats = myConnection
						.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTickets.get(i).get(1) + "\"");
				ArrayList<ArrayList<String>> movie = myConnection
						.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
				billSubTotal += Double.parseDouble(movie.get(0).get(5));
			}
		}
		// if user enters a ticket ID, it just grabs that ticket and information
		else {
			ArrayList<ArrayList<String>> emailTicket = myConnection
					.doRetrievalQuery("SELECT * FROM TICKET WHERE TicketID = \"" + ticketID + "\" AND Status <> 'paid'");
			
			message += "\t" + emailTicket.get(0).get(0);
			
			// grabbing information for the ticket and totalling the cost
			ArrayList<ArrayList<String>> seats = myConnection
					.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatId = \"" + emailTicket.get(0).get(1) + "\"");
			ArrayList<ArrayList<String>> movie = myConnection
					.doRetrievalQuery("SELECT * FROM SHOWTIME WHERE ShowtimeId = \"" + seats.get(0).get(1) + "\"");
			billSubTotal += Double.parseDouble(movie.get(0).get(5));
		}
		
		this.billTotal = billSubTotal;
		
		// the total bill is only shown if there are actually any tickets outstanding.
		if (billTotal > 0) {
			message += "\n\nYour subtotal is: " + billTotal + "\n";
			
			message += this.getCredit();
		}else {
			message += "\n\nAll reserved tickets have been paid for.\n";
		}
		
		return message;
	}
	
	/**
	 * payBill method handles updating the tickets to paid once they are processed and applies any credits 
	 * the current user has in the system.
	 * 
	 */
	public String payBill() {
		// ensuring the user actually has tickets to be paid off.
		if (billTotal > 0) {
			if (ticketID.isEmpty()) {
				ArrayList<ArrayList<String>> emailTickets = myConnection
						.doRetrievalQuery("SELECT TicketID FROM TICKET WHERE Email = \"" + email + "\" AND Status <> 'paid'");
				
				// all outstanding tickets are switched to paid 
				for (int i = 0; i < emailTickets.size(); i++)
					myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", emailTickets.get(i).get(0));

			}
			else {
				// single outstanding tickets is switched to paid 
				myConnection.doUpdateQuery("TICKET", "`Status`", "'paid'", "TicketID", ticketID);
			}
			
			
			// credits are applied to the current bill
			this.applyCredit();

			return "Tickets and receipt have been sent to your email.";
		}else {
			return "You can view your already purchased tickets in the ticket window.";
		}
	}
	
	
	/**
	 * getCredit handles retrieving any credits in the system for the current users for display back to the user.
	 * 
	 */
	public String getCredit() {
		
		ArrayList<ArrayList<String>> currentUserCredits = myConnection
				.doRetrievalQuery("SELECT * FROM MOVIECREDIT WHERE Email = \"" + email + "\"");
		
		// getting expiry
		SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date expiryDateTime = new java.util.Date();
		try {
			expiryDateTime = dateTimeFormatter.parse(currentUserCredits.get(0).get(3));
		} catch (ParseException e) {
			System.err.println("entered date is not in correct format yyyy-MM-dd");
		}
		Date now = new java.util.Date();
		
		long expiryComparison = expiryDateTime.getTime() - now.getTime();
		
		if (!currentUserCredits.isEmpty()) {
			
			double billDisplay = getBillTotal();
			
			for (int i = 0; i < currentUserCredits.size(); i++)
				//checking credits are smaller than the outstanding amount
				if (billDisplay >= Double.parseDouble(currentUserCredits.get(i).get(2))) {
					//checking the credit hasn't expired
					if (expiryComparison > 0) {
						billDisplay -= Double.parseDouble(currentUserCredits.get(i).get(2));
					}
				}
			String s = "Ticket credit for " + email + " has been applied:\n";
			s += "Subtotal after credit: $" + billDisplay + "\n";
			return s;
		}
		else {
			return "";
		}
	}
	
	/**
	 * getCredit handles consuming the credits from the database and applying them to the current bill
	 * 
	 */
	public void applyCredit() {
		
		ArrayList<ArrayList<String>> currentUserCredits = myConnection
				.doRetrievalQuery("SELECT * FROM MOVIECREDIT WHERE Email = \"" + email + "\"");
		
		if (!currentUserCredits.isEmpty()) {
			for (int i = 0; i < currentUserCredits.size(); i++)
				
				// only full credits are applied to the bill, never partial credits
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
