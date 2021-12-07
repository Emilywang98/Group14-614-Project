package View;

import javax.swing.*;
import java.awt.event.*;

public class SeatView extends JFrame {
	
	private JButton searchSeatsButton, selectSeatButton;
	private JTextField seatRowInput,seatColumnInput, emailInput;
	private JTextArea availableSeatsDisplay;
	private JLabel availableSeatsLabel,seatRowLabel, seatColumnLabel, emailLabel;
	
	public SeatView() {

        setTitle("Seat Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel panel = new JPanel(); 
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));
        
        searchSeatsButton = new JButton("SearchSeats");
        searchSeatsButton.setBounds(172, 29, 124, 21);
        panel.add(searchSeatsButton);
        
        availableSeatsLabel = new JLabel("Available seats for the movie:");
        availableSeatsLabel.setBounds(15, 60, 456, 13);
        panel.add(availableSeatsLabel); 
        
        availableSeatsDisplay = new JTextArea();
        availableSeatsDisplay.setBounds(15, 83, 456, 264);
        panel.add(availableSeatsDisplay);
       
        seatRowLabel = new JLabel("Enter a seat row:");
        seatRowLabel.setBounds(15, 357, 124, 13);
        panel.add(seatRowLabel);
        
        seatRowInput = new JTextField(10);
        seatRowInput.setBounds(133, 354, 54, 19);
        panel.add(seatRowInput);
        
        selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(370, 432, 106, 21);
        panel.add(selectSeatButton);

        seatColumnLabel = new JLabel("Enter a seat column:");
        seatColumnLabel.setBounds(243, 357, 138, 13);
        panel.add(seatColumnLabel);
        
        seatColumnInput = new JTextField();
        seatColumnInput.setBounds(370, 354, 54, 19);
        panel.add(seatColumnInput);
        seatColumnInput.setColumns(10);
        
        emailLabel = new JLabel("Enter the email you want to receive the ticket for the seat:");
        emailLabel.setBounds(15, 380, 456, 13);
        panel.add(emailLabel);
        
        emailInput = new JTextField();
        emailInput.setBounds(15, 403, 456, 19);
        panel.add(emailInput);
        emailInput.setColumns(10);
        
        getContentPane().add(panel);
        
        setVisible(true);
    }


	
	public void addSelectSeatActionListener (ActionListener listen) {
		selectSeatButton.addActionListener(listen);
	}

	public void addSearchSeatsActionListener (ActionListener listen) {
		searchSeatsButton.addActionListener(listen);
	}

	public String getSeatRow() {
		return seatRowInput.getText();
	}
	
	public String getSeatColumn() {
		return seatColumnInput.getText();
	}
	
	public String getEmailInput() {
		return emailInput.getText();
	}

	
	public void setAvailableSeatsDisplay(String availableSeats) {
		availableSeatsDisplay.setText(availableSeats);
		
	}



	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
		
	}
}

   