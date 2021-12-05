package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.SeatModel;
public class SeatView extends JFrame {
	
	private JButton searchSeatsButton, selectSeatButton;
	private JTextField seatRowInput,seatColumnInput, display, emailInput;
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
        availableSeatsDisplay.setBounds(15, 83, 456, 207);
        panel.add(availableSeatsDisplay);
       
        seatRowLabel = new JLabel("Enter a seat row:");
        seatRowLabel.setBounds(15, 310, 124, 13);
        panel.add(seatRowLabel);
        
        seatRowInput = new JTextField(10);
        seatRowInput.setBounds(149, 307, 124, 19);
        panel.add(seatRowInput);
        
        selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(338, 336, 106, 21);
        panel.add(selectSeatButton);
        
        display = new JTextField();
        display.setBounds(15, 367, 456, 19);
        panel.add(display);
        display.setColumns(10);

        seatColumnLabel = new JLabel("Enter a seat column:");
        seatColumnLabel.setBounds(15, 340, 138, 13);
        panel.add(seatColumnLabel);
        
        seatColumnInput = new JTextField();
        seatColumnInput.setBounds(149, 336, 124, 19);
        panel.add(seatColumnInput);
        seatColumnInput.setColumns(10);
        
        emailLabel = new JLabel("Enter the email you want to receive the ticket for the seat:");
        emailLabel.setBounds(15, 412, 456, 13);
        panel.add(emailLabel);
        
        emailInput = new JTextField();
        emailInput.setBounds(15, 434, 456, 19);
        panel.add(emailInput);
        emailInput.setColumns(10);
        
        getContentPane().add(panel);
        
       
//        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setVisible(true);
    }


	
	public void addSelectSeatActionListener (ActionListener listen) {
		selectSeatButton.addActionListener(listen);
	}

	public void addSearchSeatsActionListener (ActionListener listen) {
		searchSeatsButton.addActionListener(listen);
	}

	public int getSeatRow() {
		return Integer.parseInt(seatRowInput.getText());
	}
	
	public int getSeatColumn() {
		return Integer.parseInt(seatColumnInput.getText());
	}



	public void setTheDisplay(String message) {
		display.setText(message);
		
	}
	
	public void setAvailableSeatsDisplay(String availableSeats) {
		availableSeatsDisplay.setText(availableSeats);
		
	}
}

   