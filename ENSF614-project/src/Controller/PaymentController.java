package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.PaymentModel;
import View.PaymentView;


public class PaymentController {
	
	private PaymentView paymentView;
	private PaymentModel paymentModel;
	private TicketController ticketController;
	
	public PaymentController(TicketController ticketController, String email, String ticketID){
		this.paymentView = new PaymentView();
		try {
			this.paymentModel = new PaymentModel(email, ticketID);
			paymentView.setTheDisplay(paymentModel.calculateTotalBill());
		} catch (ClassNotFoundException e) {
			paymentView.setTheDisplay("Sorry, we can't connect you to the database right now!");
		}
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
			
			String cardNum;
			String cardCVV;
			String cardName;
			String expYear;
			String expMonth;
			String postalCode;
			

			try {
				// We are reading data from the view
				cardNum = paymentView.getCardNumber();
				cardCVV = paymentView.getCardCVV();
				cardName = paymentView.getCardName();
				expYear = paymentView.getCardYear();
				expMonth = paymentView.getCardMonth();
				postalCode = paymentView.getCardPostalCode();
				
				if (!cardNum.isBlank() && !cardCVV.isBlank() && !cardName.isBlank() && 
						!expYear.isBlank() && !expMonth.isBlank() && !postalCode.isBlank()) {
					// Invoking the model
					paymentView.setTheDisplay(paymentModel.payBill());
				}else {
					paymentView.setTheDisplay("Please fill in all fields.\n\n" + paymentModel.calculateTotalBill());
				}
				
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
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
