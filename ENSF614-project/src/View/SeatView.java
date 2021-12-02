package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SeatView extends JFrame {
	
	private JButton selectSeatButton;
	public SeatView() {

        JFrame frame = new JFrame("Seat Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(); 
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));
        
        JLabel availableSeatsLabel = new JLabel("Available seats for the movie:");
        availableSeatsLabel.setBounds(15, 20, 456, 13);
        panel.add(availableSeatsLabel); 
        
        JTextArea availableSeats = new JTextArea();
        availableSeats.setBounds(15, 44, 456, 338);
        panel.add(availableSeats);
       
        JLabel seatlabel = new JLabel("Enter a seat number:");
        seatlabel.setBounds(15, 409, 124, 13);
        panel.add(seatlabel);
        
        JTextField seat = new JTextField(10);
        seat.setBounds(141, 406, 124, 19);
        panel.add(seat);
        
        JButton selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(365, 405, 106, 21);
        panel.add(selectSeatButton);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }


	
	public void addSelectSeatActionListener (ActionListener listen) {
		selectSeatButton.addActionListener(listen);
	}
}

   