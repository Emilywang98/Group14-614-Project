package View;

import javax.swing.*;
import java.awt.event.*;

public class MovieSearchView extends JFrame {

	private JButton selectShowtimeButton, searchMovieButton, searchShowtimesButton;
	private JLabel movieNameLabel, showtimesLabel, enterShowtimeLabel;
	private JTextField movieName, movieSuccessDisplay, showtimeSeleted;
	private JTextArea showtimesDisplay;

	public MovieSearchView() {

		// Creating the Frame
		setSize(500, 700);
		setTitle("Movie Search Page");
//		JFrame frame = new JFrame("Movie Search Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 500);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		movieNameLabel = new JLabel("Enter Movie Name:");
		movieNameLabel.setBounds(85, 65, 121, 13);
		panel.add(movieNameLabel);

		movieName = new JTextField(20);
		movieName.setBounds(229, 65, 166, 19);
		panel.add(movieName);

		searchMovieButton = new JButton("Search");
		searchMovieButton.setBounds(188, 104, 96, 19);
		panel.add(searchMovieButton);

		movieSuccessDisplay = new JTextField();
		movieSuccessDisplay.setBounds(70, 133, 336, 19);
		panel.add(movieSuccessDisplay);
		movieSuccessDisplay.setColumns(10);

		searchShowtimesButton = new JButton("Search Showtimes");
		searchShowtimesButton.setBounds(70, 186, 159, 21);
		panel.add(searchShowtimesButton);

		showtimesLabel = new JLabel("Available showtimes for the movie:");
		showtimesLabel.setBounds(70, 217, 336, 13);
		panel.add(showtimesLabel);

		showtimesDisplay = new JTextArea();
		showtimesDisplay.setBounds(70, 240, 336, 351);
		panel.add(showtimesDisplay);

		enterShowtimeLabel = new JLabel("Enter showtime:");
		enterShowtimeLabel.setBounds(69, 601, 108, 13);
		panel.add(enterShowtimeLabel);

		showtimeSeleted = new JTextField();
		showtimeSeleted.setBounds(188, 598, 96, 19);
		panel.add(showtimeSeleted);
		showtimeSeleted.setColumns(10);

		selectShowtimeButton = new JButton("Select");
		selectShowtimeButton.setBounds(321, 597, 85, 21);
		panel.add(selectShowtimeButton);

//		JButton searchSeatsButton = new JButton("Search Seats");
//		searchSeatsButton.setBounds(355, 432, 121, 21);
//		panel.add(searchSeatsButton);
		
		getContentPane().add(panel);
		setVisible(true);
	}
//	public void addSearchSeatsActionListener(ActionListener listen) {
//
//		searchSeatsButton.addActionListener(listen);
//	}

	public void addSearchMovieActionListener(ActionListener listen) {

		searchMovieButton.addActionListener(listen);
	}

	public void addSelectShowtimeActionListener(ActionListener listen) {

		selectShowtimeButton.addActionListener(listen);

	}

	public void addSearchShowtimesActionListener(ActionListener listen) {

		searchShowtimesButton.addActionListener(listen);

	}

	public String getMovie() {

		return movieName.getText();
	}

	public String getShowtime() {

		return showtimeSeleted.getText();
	}

	public void setMovieSuccessDisplay(String message) {

		movieSuccessDisplay.setText(message);
	}


	public void setShowtimesDisplay(String message) {

		showtimesDisplay.setText(message);
	}

	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
		
	}
}