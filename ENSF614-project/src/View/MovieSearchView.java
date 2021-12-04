package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MovieSearchView extends JFrame{
	
	private JButton selectShowtimeButton, searchMovieButton, searchShowtimesButton;
	private JLabel movieNameLabel,showtimesLabel,enterShowtimeLabel;
	private JTextField movieName, movieSuccessDisplay, showtimeSeleted, showtimeSuccessDisplay;
	private JTextArea showtimesDisplay;
	
	public MovieSearchView() {

		// Creating the Frame
		JFrame frame = new JFrame("Movie Search Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

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
		
		showtimesLabel = new JLabel("Avaiable showtimes for the movie:");
		showtimesLabel.setBounds(70, 217, 336, 13);
		panel.add(showtimesLabel);
		
		showtimesDisplay = new JTextArea();
		showtimesDisplay.setBounds(70, 240, 336, 101);
		panel.add(showtimesDisplay);
		
		enterShowtimeLabel = new JLabel("Enter showtime:");
		enterShowtimeLabel.setBounds(70, 366, 108, 13);
		panel.add(enterShowtimeLabel);
		
		showtimeSeleted = new JTextField();
		showtimeSeleted.setBounds(188, 363, 96, 19);
		panel.add(showtimeSeleted);
		showtimeSeleted.setColumns(10);
		
		selectShowtimeButton = new JButton("Select");
		selectShowtimeButton.setBounds(321, 362, 85, 21);
		panel.add(selectShowtimeButton);
		
		showtimeSuccessDisplay= new JTextField();
		showtimeSuccessDisplay.setColumns(10);
		showtimeSuccessDisplay.setBounds(70, 403, 336, 19);
		panel.add(showtimeSuccessDisplay);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		frame.setVisible(true);
	}
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
	
	public String getShowtimesForMovie() {
		
		return "17:00\n18:00\n19:00";
	}

	public void setMovieSuccessDisplay(String message) {
		
		movieSuccessDisplay.setText(message);
	}
	
	public void setShowtimeSuccessDisplay(String message) {
		
		showtimeSuccessDisplay.setText(message);
	}
	
	public void setShowtimesDisplay(String message) {
		
		showtimesDisplay.setText(message);
	}
}