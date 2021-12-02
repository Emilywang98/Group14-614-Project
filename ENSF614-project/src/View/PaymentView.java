package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentView extends JFrame{

	private JButton payButton, cancelButton;
	private JTextField cardNumField, cardCVVField, cardNameField, cardDateYearField, cardDateMonthField, cardPostalCodeField;
	private JLabel cardNumPrompt, cardCVVPrompt, cardNamePrompt, cardDateYearPrompt, cardDateMonthPrompt, cardPostalCodePrompt;
	private JTextArea display;
	
	public PaymentView() {
		
		// Editing GUI window settings
		int width = 600;
		setSize(width,600);
		setTitle("Movie Payment Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Card name prompt and field
		
		JPanel cardNamePanel = new JPanel();
		cardNamePanel.setLayout(new GridLayout(1,2));
		
		cardNamePrompt = new JLabel("Name appearing on credit card: ");
		cardNameField = new JTextField(100);
		
		cardNamePanel.add(cardNamePrompt);
		cardNamePanel.add(cardNameField);
		cardNamePanel.setPreferredSize(new Dimension(width,40));
		cardNamePanel.setMaximumSize(new Dimension(width,40));
	
		add(cardNamePanel);
		
		// Card number prompt and field
		
		JPanel cardNumberPanel = new JPanel();
		cardNumberPanel.setLayout(new GridLayout(1,2));
		
		cardNumPrompt = new JLabel("Credit card number: ");
		cardNumField = new JTextField(100);
		
		cardNumberPanel.add(cardNumPrompt);
		cardNumberPanel.add(cardNumField);
		cardNumberPanel.setPreferredSize(new Dimension(width,40));
		cardNumberPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardNumberPanel);
		
		// Card CVV prompt and field
		
		JPanel cardCVVPanel = new JPanel();
		cardCVVPanel.setLayout(new GridLayout(1,2));
		
		cardCVVPrompt = new JLabel("Card CVV (3 or 4 digits): ");
		cardCVVField = new JTextField(100);
		
		cardCVVPanel.add(cardCVVPrompt);
		cardCVVPanel.add(cardCVVField);
		cardCVVPanel.setPreferredSize(new Dimension(width,40));
		cardCVVPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardCVVPanel);

		// Card expiry month prompt and field
		
		JPanel cardExpiryMonthPanel = new JPanel();
		cardExpiryMonthPanel.setLayout(new GridLayout(1,2));
		
		cardDateMonthPrompt = new JLabel("Expiry month: ");
		cardDateMonthField = new JTextField(100);
		
		cardExpiryMonthPanel.add(cardDateMonthPrompt);
		cardExpiryMonthPanel.add(cardDateMonthField);
		cardExpiryMonthPanel.setPreferredSize(new Dimension(width,40));
		cardExpiryMonthPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardExpiryMonthPanel);
		
		// Card expiry year prompt and field
		
		JPanel cardExpiryYearPanel = new JPanel();
		cardExpiryYearPanel.setLayout(new GridLayout(1,2));
		
		cardDateYearPrompt = new JLabel("Expiry year: ");
		cardDateYearField = new JTextField(100);
		
		cardExpiryYearPanel.add(cardDateYearPrompt);
		cardExpiryYearPanel.add(cardDateYearField);
		cardExpiryYearPanel.setPreferredSize(new Dimension(width,40));
		cardExpiryYearPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardExpiryYearPanel);
		
		// Card postal code prompt and field
		
		JPanel cardPostalPanel = new JPanel();
		cardPostalPanel.setLayout(new GridLayout(1,2));
		
		cardPostalCodePrompt = new JLabel("Postal code: ");
		cardPostalCodeField = new JTextField(100);
		
		cardPostalPanel.add(cardPostalCodePrompt);
		cardPostalPanel.add(cardPostalCodeField);
		cardPostalPanel.setPreferredSize(new Dimension(width,40));
		cardPostalPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardPostalPanel);
		
		// display area

		display = new JTextArea("", 5, 20);
		display.setWrapStyleWord(true);
		display.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(scroll);
		
		//add remove buttons
		
		JPanel payCancelPanel = new JPanel();
		payCancelPanel.setLayout(new GridLayout(1,2));
		
		payButton = new JButton("Pay");
		cancelButton = new JButton("Cancel");
		
		payCancelPanel.add(payButton);
		payCancelPanel.add(cancelButton);
		payCancelPanel.setPreferredSize(new Dimension(width,75));
		payCancelPanel.setMaximumSize(new Dimension(width,75));
		
		add(payCancelPanel);

	}
	
	public void addPayActionListener (ActionListener listen) {
		payButton.addActionListener(listen);
	}
	
	public void addCancelActionListener (ActionListener listen) {
		cancelButton.addActionListener(listen);
	}
	
	public String getCardName () {
		return cardNameField.getText();
	}
	
	public String getCardPostalCode () {
		return cardPostalCodeField.getText();
	}
	
	public int getCardNumber () {
		return Integer.parseInt(cardNumField.getText());
	}
	
	public int getCardCVV () {
		return Integer.parseInt(cardCVVField.getText());
	}
	
	public int getCardMonth () {
		return Integer.parseInt(cardDateMonthField.getText());
	}
	
	public int getCardYear () {
		return Integer.parseInt(cardDateYearField.getText());
	}
	
	public void setTheDisplay (String message) {
		display.setText(message);
	}
	
}
