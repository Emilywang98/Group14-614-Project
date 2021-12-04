package Controller;

import View.MovieSearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieController {
    private MovieSearchView movieSearchView;
    private SeatController seatController;
    private MovieController thisMovieController;

    public MovieController() {
        movieSearchView = new MovieSearchView();
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
                movieSearchView.setMovieSuccessDisplay("Movie " + movieName + " was found");

            } catch (Exception ex) {
                movieSearchView.setMovieSuccessDisplay("Error!");
            }
        }
    }

    class SearchShowtimesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String showtimes;
            try {
                showtimes = movieSearchView.getShowtimesForMovie();
                movieSearchView.setShowtimesDisplay(showtimes);

            } catch (Exception ex) {
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
                movieSearchView.setShowtimeSuccessDisplay("Showtime " + showtime_selected + " was successfully selected");
                seatController = new SeatController(thisMovieController);

                seatController.getView().setVisible(true);
//				movieSearchView.setVisible(false);
            } catch (Exception ex) {
                movieSearchView.setShowtimeSuccessDisplay("Error!");
            }
        }
    }
}

