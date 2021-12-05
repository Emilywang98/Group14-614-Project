package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.SeatModel;
public class SeatView extends JFrame {
	
	private JButton searchSeatsButton, selectSeatButton;
	private JTextField seatRowInput, display;
	private JTextArea availableSeatsDisplay;
	private JLabel availableSeatsLabel,seatRowLabel;
	private JTextField seatColumnInput;
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
        availableSeatsDisplay.setBounds(15, 83, 456, 240);
        panel.add(availableSeatsDisplay);
       
        seatRowLabel = new JLabel("Enter a seat row:");
        seatRowLabel.setBounds(15, 343, 124, 13);
        panel.add(seatRowLabel);
        
        seatRowInput = new JTextField(10);
        seatRowInput.setBounds(149, 340, 124, 19);
        panel.add(seatRowInput);
        
        selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(341, 387, 106, 21);
        panel.add(selectSeatButton);
        
        display = new JTextField();
        display.setBounds(15, 434, 456, 19);
        panel.add(display);
        display.setColumns(10);

        JLabel seatColumnLabel = new JLabel("Enter a seat column:");
        seatColumnLabel.setBounds(15, 391, 138, 13);
        panel.add(seatColumnLabel);
        
        seatColumnInput = new JTextField();
        seatColumnInput.setBounds(149, 388, 124, 19);
        panel.add(seatColumnInput);
        seatColumnInput.setColumns(10);
        
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

	public int getSeatNumber() {
		return Integer.parseInt(seatRowInput.getText());
	}
	
//	public String getAvailableSeats() {
//		return seatModel.returnSeats();
//		// return a list of seats
//	}



	public void setTheDisplay(String message) {
		display.setText(message);
		
	}
	
	public void setAvailableSeatsDisplay(String availableSeats) {
		availableSeatsDisplay.setText(availableSeats);
		
	}
}

   