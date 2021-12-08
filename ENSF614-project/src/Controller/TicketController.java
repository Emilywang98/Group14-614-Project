package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.TicketModel;
import View.PaymentView;
import View.TicketView;

public class TicketController {

	private TicketView ticketView;
	private TicketModel ticketModel;
	private PaymentController paymentController;
	private TicketController thisTicketController;
	
	public TicketController(){
		ticketView = new TicketView();
		try {
			ticketModel = new TicketModel();
		} catch (ClassNotFoundException e) {
			// catching if the database wont read from the model.
			ticketView.setTicketDisplay("Sorry, we can't connect you to the database right now!");
		}
		
		thisTicketController = this;
		ticketView.setVisible(true);
		
		// adding active listeners
		ticketView.getTicketActionListener(new GetTicketsListener());
		ticketView.goToPaymentActionListener(new GoToPaymentListener());
		ticketView.cancelTicketActionListener(new CancelTicketListener());
	}
	
	public TicketView getView() {
		return ticketView;
	}
	
    /**
     * Helper subclass GetTicketsListener used to check for the click of the "Retrieve tickets" button.
     * This will start the process to get the users tickets from the model/DB and display them back to the view.
     * 
     * @author Greg
     *
     */
	class GetTicketsListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String ticketID;
			String email;
			
			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				// Invoking the model with info from the view, sending response to view
				ticketView.setTicketDisplay(ticketModel.getTicketInfo(email, ticketID));
				
			}catch(IndexOutOfBoundsException ex) {
				// specifically catching if API is returning empty sets
				ticketView.setTicketDisplay("That ticket does not exist!");
			}catch(Exception ex) {
				ex.printStackTrace();
				ticketView.setTicketDisplay("Error!");
			}
		
		}
	}
	
    /**
     * Helper subclass GoToPaymentListener used to check for the click of the "Pay for tickets" button
     * This will send the user to the payment view.
     * 
     * @author Greg
     *
     */
	class GoToPaymentListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String ticketID;
			String email;

			try {
				
				// We are reading data from the view
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				
				if (email.isEmpty()) {
					// Error handling if user didn't enter an email
					ticketView.setTicketDisplay("Please enter your email to pay for specified (or all) ticket(s).");
				}
				else {
					// Passing ticket off to payment
					paymentController = new PaymentController(thisTicketController, email, ticketID);
					
					paymentController.getView().setVisible(true);
					ticketView.setVisible(false);
				}
				
				
			}catch(IndexOutOfBoundsException ex) {
				// specifically catching if API is returning empty sets
				ex.printStackTrace();
				ticketView.setTicketDisplay("That ticket does not exist!");
			}catch(Exception ex) {
				ex.printStackTrace();;
				ticketView.setTicketDisplay("Error!");
			}
		
		}
		
	}
	
    /**
     * Helper subclass CancelTicketListener used to check for the click of the Cancel Ticket button
     * This will start the process to cancel tickets from the model/DB and display the changes back to the view.
     * 
     * @author Greg
     *
     */
	class CancelTicketListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String ticketID;
			String email;
			

			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				// Invoking the model with info from the view, sending response to view
				ticketView.setTicketDisplay(ticketModel.cancelTicket(email, ticketID));
				
			}catch(IndexOutOfBoundsException ex) {
				// specifically catching if API is returning empty sets
				ticketView.setTicketDisplay("That ticket does not exist!");
			}catch(Exception ex) {
				ex.printStackTrace();
				ticketView.setTicketDisplay("Error!");
			}
		
		}
	}
	
}
