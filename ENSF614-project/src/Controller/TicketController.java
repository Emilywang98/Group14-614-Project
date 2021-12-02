package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PaymentView;
import View.TicketView;

public class TicketController {

	private TicketView ticketView;
	private PaymentController paymentController;
	private TicketController thisTicketController;
	
	public TicketController(){
		ticketView = new TicketView();
		thisTicketController = this;
		
		ticketView.setVisible(true);
		
		ticketView.getTicketActionListener(new GetTicketListener());
		ticketView.goToPaymentActionListener(new GoToPaymentListener());
		ticketView.cancelTicketActionListener(new CancelTicketListener());
		ticketView.returnActionListener(new ReturnListener());
	}
	
	public TicketView getView() {
		return ticketView;
	}
	
	class GetTicketListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			// cardNumField, cardCVVField, cardNameField, cardDateYearField, cardDateMonthField, cardPostalCodeField;
			
			int cardNum;
			String email;
			

			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				cardNum = ticketView.getCardNumber();
				
				// Invoking the model
				ticketView.setTicketDisplay("Here are your tickets:\n");
				
			}catch(Exception ex) {
				ticketView.setTicketDisplay("Error!");
			}
		
		}
	}
	
	class GoToPaymentListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {

			try {
				paymentController = new PaymentController(thisTicketController);
				
				paymentController.getView().setVisible(true);
				ticketView.setVisible(false);
				
			}catch(Exception ex) {
				ticketView.setTicketDisplay("Error!");
			}
		
		}
		
	}
	
	class CancelTicketListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			// cardNumField, cardCVVField, cardNameField, cardDateYearField, cardDateMonthField, cardPostalCodeField;
			
			int cardNum;
			String email;
			

			try {
				// We are reading data from the view
				email = ticketView.getEmail();
				cardNum = ticketView.getCardNumber();
				
				// Invoking the model
				ticketView.setTicketDisplay("The following tickets have been cancelled:\n");
				
			}catch(Exception ex) {
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
