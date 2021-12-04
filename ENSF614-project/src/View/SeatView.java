package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeatView extends JFrame {
	
	
	private JButton searchSeatsButton, selectSeatButton;
	private JTextField seat, display;
	private JTextArea availableSeatsDisplay;
	private JLabel availableSeatsLabel,seatLabel;
	public SeatView() {

        JFrame frame = new JFrame("Seat Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(); 
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));
        
        searchSeatsButton = new JButton("SearchSeats");
        searchSeatsButton.setBounds(172, 29, 124, 21);
        panel.add(searchSeatsButton);
        
        availableSeatsLabel = new JLabel("Available seats for the movie:");
        availableSeatsLabel.setBounds(15, 77, 456, 13);
        panel.add(availableSeatsLabel); 
        
        availableSeatsDisplay = new JTextArea();
        availableSeatsDisplay.setBounds(15, 100, 456, 282);
        panel.add(availableSeatsDisplay);
       
        seatLabel = new JLabel("Enter a seat number:");
        seatLabel.setBounds(15, 409, 124, 13);
        panel.add(seatLabel);
        
        seat = new JTextField(10);
        seat.setBounds(141, 406, 124, 19);
        panel.add(seat);
        
        selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(365, 405, 106, 21);
        panel.add(selectSeatButton);
        
        display = new JTextField();
        display.setBounds(15, 434, 456, 19);
        panel.add(display);
        display.setColumns(10);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }


	
	public void addSelectSeatActionListener (ActionListener listen) {
		selectSeatButton.addActionListener(listen);
	}

	public void addSearchSeatsActionListener (ActionListener listen) {
		searchSeatsButton.addActionListener(listen);
	}

	public int getSeatNumber() {
		// TODO Auto-generated method stub
		return Integer.parseInt(seat.getText());
	}
	
	public String getAvaialbleSeats() {
		return "1\n2\n3\n4\n5";
		// return a list of seats
	}



	public void setTheDisplay(String message) {
		// TODO Auto-generated method stub
		display.setText(message);
		
	}
	
	public void setAvailableSeatsDisplay(String message) {
		// TODO Auto-generated method stub
		availableSeatsDisplay.setText(message);
		
	}
}

   