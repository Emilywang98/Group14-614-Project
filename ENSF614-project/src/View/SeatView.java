package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SeatView extends JFrame {
	
	private JButton selectSeatButton;
	private JTextField seat, display;
	private JTextArea availableSeats;
	private JLabel availableSeatsLabel,seatLabel;
	public SeatView() {

        JFrame frame = new JFrame("Seat Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(); 
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));
        
        availableSeatsLabel = new JLabel("Available seats for the movie:");
        availableSeatsLabel.setBounds(15, 20, 456, 13);
        panel.add(availableSeatsLabel); 
        
        availableSeats = new JTextArea();
        availableSeats.setBounds(15, 44, 456, 338);
        panel.add(availableSeats);
       
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



	public int getSeat() {
		// TODO Auto-generated method stub
		return Integer.parseInt(seat.getText());
	}



	public void setTheDisplay(String message) {
		// TODO Auto-generated method stub
		display.setText(message);
		
	}
}

   