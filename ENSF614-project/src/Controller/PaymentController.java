package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PaymentView;


public class PaymentController {
	
	private PaymentView paymentView;
	private TicketController ticketController;
	
	public PaymentController(TicketController ticketController){
		this.paymentView = new PaymentView();
		this.ticketController = ticketController;
		
		ticketController.getView().setVisible(false);
		paymentView.setVisible(true);
		
		paymentView.addPayActionListener(new PayListener());
		paymentView.addCancelActionListener(new CancelListener());
	}
	
	public PaymentView getView() {
		return paymentView;
	}
	
	class PayListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			// cardNumField, cardCVVField, cardNameField, cardDateYearField, cardDateMonthField, cardPostalCodeField;
			
			int cardNum;
			int cardCVV;
			String cardName;
			int expYear;
			int expMonth;
			String postalCode;
			

			try {
				// We are reading data from the view
				cardNum = paymentView.getCardNumber();
				cardCVV = paymentView.getCardCVV();
				cardName = paymentView.getCardName();
				expYear = paymentView.getCardYear();
				expMonth = paymentView.getCardMonth();
				postalCode = paymentView.getCardPostalCode();
				
				// Invoking the model
				paymentView.setTheDisplay("Tickets purchased, please check your email for tickets.");
				
			}catch(NumberFormatException ex) {
				paymentView.setTheDisplay("Error!");
			}
		
		}
		
	}
	
	class CancelListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {

			try {
				// We are reading data from the view
				
				ticketController.getView().setVisible(true);
				paymentView.setVisible(false);
				
			}catch(NumberFormatException ex) {
				paymentView.setTheDisplay("Error!");
			}
		
		}
		
	}

}
