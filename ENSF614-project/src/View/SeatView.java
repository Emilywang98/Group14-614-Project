package View;

import javax.swing.*;
import java.awt.event.*;

/**
 * Seat view on the GUI
 *
 */
public class SeatView extends JFrame {
	
	private JButton searchSeatsButton, selectSeatButton;
	private JTextField seatRowInput,seatColumnInput, emailInput;
	private JTextArea availableSeatsDisplay;
	private JLabel availableSeatsLabel,seatRowLabel, seatColumnLabel, emailLabel;
	
	public SeatView() {

        setTitle("Seat Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);

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
        availableSeatsDisplay.setBounds(15, 83, 456, 464);
        panel.add(availableSeatsDisplay);
       
        seatRowLabel = new JLabel("Enter a seat row:");
        seatRowLabel.setBounds(15, 557, 124, 13);
        panel.add(seatRowLabel);
        
        seatRowInput = new JTextField(10);
        seatRowInput.setBounds(136, 554, 54, 19);
        panel.add(seatRowInput);
        
        selectSeatButton = new JButton("Select Seat");
        selectSeatButton.setBounds(365, 632, 106, 21);
        panel.add(selectSeatButton);

        seatColumnLabel = new JLabel("Enter a seat column:");
        seatColumnLabel.setBounds(244, 557, 138, 13);
        panel.add(seatColumnLabel);
        
        seatColumnInput = new JTextField();
        seatColumnInput.setBounds(369, 554, 54, 19);
        panel.add(seatColumnInput);
        seatColumnInput.setColumns(10);
        
        emailLabel = new JLabel("Enter the email you want to receive the ticket for the seat:");
        emailLabel.setBounds(15, 580, 456, 13);
        panel.add(emailLabel);
        
        emailInput = new JTextField();
        emailInput.setBounds(15, 603, 456, 19);
        panel.add(emailInput);
        emailInput.setColumns(10);
        
        getContentPane().add(panel);
        setVisible(true);
    }
	
	/**
	 * The method is used to add actionListener for selectSeatButton
	 * @param listen
	 */
	public void addSelectSeatActionListener (ActionListener listen) {
		selectSeatButton.addActionListener(listen);
	}
	
	/**
	 * The method is used to add actionListener for searchSeatsButton
	 * @param listen
	 */
	public void addSearchSeatsActionListener (ActionListener listen) {
		searchSeatsButton.addActionListener(listen);
	}
	
	/**
	 * The method is used to get seat row input from user
	 * @return seat row input from user
	 */
	public String getSeatRow() {
		return seatRowInput.getText();
	}
	
	/**
	 * The method is used to get seat column input from user
	 * @return seat column input from user
	 */
	public String getSeatColumn() {
		return seatColumnInput.getText();
	}
	
	/**
	 * The method is used to get email input from user
	 * @return seat email input from user
	 */
	public String getEmailInput() {
		return emailInput.getText();
	}
	
	/**
	 * The method is used to set the display of all available seats for the movie
	 * @param availableSeats
	 */
	public void setAvailableSeatsDisplay(String availableSeats) {
		availableSeatsDisplay.setText(availableSeats);
	}
	
	/**
	 * The method is used to display a message 
	 * @param message
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}

   