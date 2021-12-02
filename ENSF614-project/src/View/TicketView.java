package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicketView extends JFrame{
	
	private JButton getTicketButton, goToPaymentButton, cancelTicketButton, returnButton;
	private JTextField emailField, cardNumField;
	private JLabel emailPrompt, cardNumPrompt;
	private JTextArea ticketDisplay;
	
	public TicketView() {
	
		// Editing GUI window settings
		int width = 600;
		setSize(width,600);
		setTitle("Movie Ticket Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
	
		// Email prompt and field
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new GridLayout(1,2));
		
		emailPrompt = new JLabel("Email used to select seats: ");
		emailField = new JTextField(100);
		
		emailPanel.add(emailPrompt);
		emailPanel.add(emailField);
		emailPanel.setPreferredSize(new Dimension(width,40));
		emailPanel.setMaximumSize(new Dimension(width,40));
	
		add(emailPanel);
		
		// Card number prompt and field
		
		JPanel cardNumberPanel = new JPanel();
		cardNumberPanel.setLayout(new GridLayout(1,2));
		
		cardNumPrompt = new JLabel("***MAYBE*** Credit card number used to purchase tickets: ");
		cardNumField = new JTextField(100);
		
		cardNumberPanel.add(cardNumPrompt);
		cardNumberPanel.add(cardNumField);
		cardNumberPanel.setPreferredSize(new Dimension(width,40));
		cardNumberPanel.setMaximumSize(new Dimension(width,40));
	
		add(cardNumberPanel);
		
		// get ticket button
		
		JPanel getTicketButtonPanel = new JPanel();
		getTicketButtonPanel.setLayout(new GridLayout(1,1));
		
		getTicketButton = new JButton("Retrieve Tickets");
		
		getTicketButtonPanel.add(getTicketButton);
		getTicketButtonPanel.setPreferredSize(new Dimension(width,75));
		getTicketButtonPanel.setMaximumSize(new Dimension(width,75));
		
		add(getTicketButtonPanel);
		
		// ticket display area
	
		ticketDisplay = new JTextArea("", 5, 20);
		ticketDisplay.setWrapStyleWord(true);
		ticketDisplay.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(ticketDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
		add(scroll);
		
		// pay or cancel ticket buttons
		
		JPanel payCancelButtonsPanel = new JPanel();
		payCancelButtonsPanel.setLayout(new GridLayout(1,2));
		
		goToPaymentButton = new JButton("Pay for tickets");
		cancelTicketButton = new JButton("Cancel tickets");
		
		payCancelButtonsPanel.add(goToPaymentButton);
		payCancelButtonsPanel.add(cancelTicketButton);
		payCancelButtonsPanel.setPreferredSize(new Dimension(width,75));
		payCancelButtonsPanel.setMaximumSize(new Dimension(width,75));
		
		add(payCancelButtonsPanel);
		
		// get ticket button
		
		JPanel returnButtonPanel = new JPanel();
		returnButtonPanel.setLayout(new GridLayout(1,1));
		
		returnButton = new JButton("Return");
		
		returnButtonPanel.add(returnButton);
		returnButtonPanel.setPreferredSize(new Dimension(width,75));
		returnButtonPanel.setMaximumSize(new Dimension(width,75));
		
		add(returnButtonPanel);
	
	}
	
	public void getTicketActionListener (ActionListener listen) {
		getTicketButton.addActionListener(listen);
	}
	
	public void goToPaymentActionListener (ActionListener listen) {
		goToPaymentButton.addActionListener(listen);
	}
	
	public void cancelTicketActionListener (ActionListener listen) {
		cancelTicketButton.addActionListener(listen);
	}
	
	public void returnActionListener (ActionListener listen) {
		returnButton.addActionListener(listen);
	}
	
	public void setTicketDisplay (String message) {
		ticketDisplay.setText(message);
	}
	
	public String getEmail () {
		return emailField.getText();
	}
	
	public int getCardNumber () {
		return Integer.parseInt(cardNumField.getText());
	}
}
