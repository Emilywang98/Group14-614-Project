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
			
			// Invoking the model, sending initial response to view
			paymentView.setTheDisplay(paymentModel.calculateTotalBill());
			
		} catch (ClassNotFoundException e) {
			
			// If the DB is disconnected for whatever reason the user is informed
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
	
	/**
     * Helper subclass PayListener used to check for the click of the "Pay" button.
     * This will initiate the payment process and display the changes back to the user.
     * 
     * @author Greg
     *
     */
	class PayListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
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
				
				// ensuring the user has at least entered something for every field as we are not actually processing payment
				if (!cardNum.isBlank() && !cardCVV.isBlank() && !cardName.isBlank() && 
						!expYear.isBlank() && !expMonth.isBlank() && !postalCode.isBlank()) {

					// Invoking the model, sending response to view
					paymentView.setTheDisplay(paymentModel.payBill());
				}else {
					// Informing user they have to enter all fields for payment.
					paymentView.setTheDisplay("Please fill in all fields.\n\n" + paymentModel.calculateTotalBill());
				}
				
			}catch(Exception ex) {
				paymentView.setTheDisplay("Error!");
			}
		
		}
		
	}
	
	/**
     * Helper subclass CancelListener used to check for the click of the "Return to Tickets" button.
     * This will send the user back to the ticket view.
     * 
     * @author Greg
     *
     */
	class CancelListener implements ActionListener{
		
		@Override
		public void actionPerformed (ActionEvent e) {

			// Passing ticket off to payment
			ticketController.getView().setVisible(true);
			paymentView.setVisible(false);
		
		}
		
	}

}
