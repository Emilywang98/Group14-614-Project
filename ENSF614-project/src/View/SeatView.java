package View;

import javax.swing.*;
import java.awt.*;

public class SeatView extends JFrame {
	

	public SeatView() {

        //Creating the Frame
        JFrame frame = new JFrame("Movie Ticket Reservation App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Text Area at the Center
        JPanel panel1 = new JPanel(); 
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));
        JLabel availableSeatsLabel = new JLabel("Available seats for the movie:");
        availableSeatsLabel.setBounds(15, 20, 456, 13);
        JTextArea availableSeats = new JTextArea();
        availableSeats.setBounds(15, 44, 456, 338);
        panel1.setLayout(null);
        panel1.add(availableSeatsLabel); // Components Added using Flow Layout
        panel1.add(availableSeats);
        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        JLabel seatlabel = new JLabel("Enter a seat number:");
        seatlabel.setBounds(15, 409, 124, 13);
        panel1.add(seatlabel);
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        tf.setBounds(141, 406, 124, 19);
        panel1.add(tf);
        JButton select = new JButton("Select Seat");
        select.setBounds(365, 405, 106, 21);
        panel1.add(select);
        frame.setVisible(true);
    }
}

   