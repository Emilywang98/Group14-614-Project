package View;

import javax.swing.*;
import java.awt.*;

public class MovieSearchView extends JFrame {
	private JTextField textField;
	public MovieSearchView() {

		// Creating the Frame
		JFrame frame = new JFrame("Movie Ticket Reservation App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// panel at the NORTH
		JPanel panel = new JPanel(); // the panel is not visible in output
		
		JLabel movieNameLabel = new JLabel("Enter Movie Name:");
		movieNameLabel.setBounds(69, 9, 88, 13);
		JTextField movieName = new JTextField(10); // accepts upto 10 characters
		movieName.setBounds(162, 6, 86, 19);
		JButton search = new JButton("Search");
		search.setBounds(253, 5, 63, 21);
		panel.setLayout(null);
		
		
		panel.add(movieNameLabel); // Components Added using Flow Layout
		panel.add(movieName);
		panel.add(search);
		
		
		//panel at the CENTER
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		JTextArea output = new JTextArea(5, 20);
		output.setBounds(70, 104, 319, 95);
	    centerPanel.add(output);
			
			
		//panel at the South
		
		JTextArea theatreLocations = new JTextArea(5, 20);
		theatreLocations.setBounds(0, 0, 0, 0);
		centerPanel.add(theatreLocations);
		
		// Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		
		JLabel theatreLocationsLabel = new JLabel("Theatre are currently showing the movie:");
		theatreLocationsLabel.setBounds(70, 217, 336, 13);
		centerPanel.add(theatreLocationsLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(70, 240, 336, 101);
		centerPanel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Enter Movie Name:");
		lblNewLabel.setBounds(70, 49, 137, 13);
		centerPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 46, 218, 19);
		centerPanel.add(textField);
		textField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(188, 75, 96, 19);
		centerPanel.add(searchButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(388, 104, 19, 93);
		centerPanel.add(scrollBar);
		
		frame.setVisible(true);
	}
}