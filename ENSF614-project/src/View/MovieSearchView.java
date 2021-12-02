package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieSearchView extends JFrame {
	private JButton selectShowtimeButton, searchMovieButton;
	private JLabel movieNameLabel,showtimesLabel,enterShowtimeLabel;
	private JTextField movieName, showtimeSeleted, output;
	private JTextArea showtimes;
	public MovieSearchView() {

		// Creating the Frame
		JFrame frame = new JFrame("Movie Search Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		
		movieNameLabel = new JLabel("Enter Movie Name:");
		movieNameLabel.setBounds(93, 109, 121, 13);
		panel.add(movieNameLabel);
		
		movieName = new JTextField(20); 
		movieName.setBounds(224, 106, 166, 19);
		panel.add(movieName);
		
		searchMovieButton = new JButton("Search");
		searchMovieButton.setBounds(188, 144, 96, 19);
		panel.add(searchMovieButton);
		
		output = new JTextField();
		output.setBounds(70, 174, 336, 19);
		panel.add(output);
		output.setColumns(10);
		
		showtimesLabel = new JLabel("Avaiable showtimes for the movie:");
		showtimesLabel.setBounds(70, 217, 336, 13);
		panel.add(showtimesLabel);
		
		showtimes = new JTextArea();
		showtimes.setBounds(70, 240, 336, 101);
		panel.add(showtimes);
		
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
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		frame.setVisible(true);
	}
}