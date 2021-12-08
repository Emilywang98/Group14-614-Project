package Controller;

import View.MovieSearchView;
import View.SeatView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.SeatModel;
import Model.MovieModel;

public class MovieController {
	MovieSearchView movieSearchView;
	SeatView seatView;
	SeatModel seatModel;
	SeatController seatController;
	MovieController thisMovieController;
	MovieModel movieModel;
	ArrayList<String> movies;
	ArrayList<String> showtimeId;

	public MovieController() {
		movieSearchView = new MovieSearchView();
		movieSearchView.getContentPane().setLayout(null);
		try {
			movieModel = new MovieModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		thisMovieController = this;

		movieSearchView.setVisible(true);

		movieSearchView.addSearchMovieActionListener(new SearchMovieListener());
		movieSearchView.addSelectShowtimeActionListener(new SelectShowtimeListener());
		movieSearchView.addSearchShowtimesActionListener(new SearchShowtimesListener());
	}

	public MovieSearchView getView() {
		return movieSearchView;
	}

	class SearchMovieListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String movieName;
			try {
				movieName = movieSearchView.getMovie();
				if (!movieName.isEmpty()) {

					movies = movieModel.getMovieVerification(movieName);

					movieSearchView.setMovieSuccessDisplay("Movie " + '"' + movieName + '"' + " was found");
				} else {
					movieSearchView.setMovieSuccessDisplay("You must enter a movie name!");
				}
			} catch (NullPointerException ex) {
				movieSearchView.setMovieSuccessDisplay("Movie was not found!");
			}
		}
	}

	
	class SearchShowtimesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//        	String showtime_selected;
			ArrayList<String> availableShowtimes;
			System.out.println(movieSearchView.getMovie());
			try {
				availableShowtimes = movieModel.returnShowtimesForMovie(movieSearchView.getMovie());
				if(movieSearchView.getMovie().isEmpty()) {
					movieSearchView.displayMessage("You must search a movie first!");
				}
				else {
					StringBuffer sb = new StringBuffer();

					for (String s : availableShowtimes) {
						sb.append(s);
						sb.append("\n");
					}
					String availableShowtimesString = sb.toString();
					movieSearchView.setShowtimesDisplay(availableShowtimesString);
				}
				

			} catch (NullPointerException ex) {
				movieSearchView.setShowtimesDisplay("Error!");
			}
		}
	}
	class SelectShowtimeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String showtime_selected;

			try {
				showtime_selected = movieSearchView.getShowtime();
				if (!showtime_selected.isEmpty()) {
					showtimeId = movieModel.getShowtimeVerification(showtime_selected);

//					movieSearchView
//							.setShowtimeSuccessDisplay("Showtime " + showtime_selected + " was successfully selected");
					movieSearchView.displayMessage("Showtime " + showtime_selected + " was successfully selected");
					seatController = new SeatController(showtimeId.get(0));

					seatController.getView().setVisible(true);
					movieSearchView.setVisible(false);
				} else if (movieSearchView.getMovie().isEmpty()){
					movieSearchView.displayMessage("You must search a movie first!");
				}
				else {
					movieSearchView.displayMessage("You must enter a showtime!");
				}
			} catch (NullPointerException ex) {
				movieSearchView.displayMessage("You must enter an available showtime!");
			}
		}
	}
	
}
