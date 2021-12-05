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
			ticketView.setTicketDisplay("Sorry, we can't connect you to the database right now!");
		}
		thisTicketController = this;
		
		ticketView.setVisible(true);
		
		ticketView.getTicketActionListener(new GetTicketsListener());
		ticketView.goToPaymentActionListener(new GoToPaymentListener());
		ticketView.cancelTicketActionListener(new CancelTicketListener());
		ticketView.returnActionListener(new ReturnListener());
	}
	
	public TicketView getView() {
		return ticketView;
	}
	
	class GetTicketsListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String ticketID;
			String email;
			
			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				// Invoking the model
				ticketView.setTicketDisplay(ticketModel.getTicketInfo(email, ticketID));
				
			}catch(Exception ex) {
				ticketView.setTicketDisplay("There are no tickets matching your search criteria.");
			}
		
		}
	}
	
	class GoToPaymentListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String ticketID;
			String email;

			try {
				
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				
				if (email.isEmpty()) {
					ticketView.setTicketDisplay("Please enter your email to pay for specified (or all) ticket(s).");
				}
				else {
					paymentController = new PaymentController(thisTicketController, email, ticketID);
					
					paymentController.getView().setVisible(true);
					ticketView.setVisible(false);
				}
				
				
			}catch(Exception ex) {
				ticketView.setTicketDisplay("Error!");
			}
		
		}
		
	}
	
	class CancelTicketListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			// cardNumField, cardCVVField, cardNameField, cardDateYearField, cardDateMonthField, cardPostalCodeField;
			
			String ticketID;
			String email;
			

			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				ticketID = ticketView.getTicketIDNumber();
				
				// Invoking the model
				ticketView.setTicketDisplay(ticketModel.cancelTicket(email, ticketID));
				
			}catch(Exception ex) {
				ex.printStackTrace();
				ticketView.setTicketDisplay("Error!");
			}
		
		}
	}
	
	class ReturnListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {

			try {
				
				
			}catch(Exception ex) {
				
			}
		
		}
		
	}
	
}
