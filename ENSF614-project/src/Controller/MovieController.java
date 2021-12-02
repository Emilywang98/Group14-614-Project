package Controller;

import View.MovieSearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieController {
	MovieSearchView movieSearchView;

	private SeatController seatController;

	public MovieController(SeatController seatController) {
		this.movieSearchView = new MovieSearchView();

		seatController.getView().setVisible(false);
		movieSearchView.setVisible(true);

		movieSearchView.addSearchMovieActionListener(new SearchMovieListener());
		movieSearchView.addSelectShowtimeActionListener(new SelectShowtimeListener());
	}

	class SearchMovieListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String movieName;
			try {
				movieName = movieSearchView.getMovie();

				movieSearchView.setTheDisplay("Movie was found");
			} catch (NumberFormatException ex) {
				movieSearchView.setTheDisplay("Error!");
			}
		}
	}

	class SelectShowtimeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String showtime_selected;
			try {
				showtime_selected = movieSearchView.getShowtime();

				seatController.getView().setVisible(true);
				movieSearchView.setVisible(false);
			} catch (NumberFormatException ex) {
				movieSearchView.setTheDisplay("Error!");
			}
		}
	}
}
