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
    ArrayList<String > movies;
    ArrayList<String > showtimes;

    public MovieController(MovieSearchView movieSearchView, MovieModel movieModel) {
        this.movieSearchView = movieSearchView;
        this.movieModel = movieModel;
        thisMovieController = this;

//        movieSearchView.setVisible(true);

        movieSearchView.addSearchMovieActionListener(new SearchMovieListener());
        movieSearchView.addSelectShowtimeActionListener(new SelectShowtimeListener());
        movieSearchView.addSearchShowtimesActionListener(new SearchShowtimesListener());
        movieSearchView.addSearchSeatsActionListener(new SearchSeatsListener());
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
                
                movies = movieModel.getMovieVerification(movieName);
                
                movieSearchView.setMovieSuccessDisplay("Movie " + '"'+ movieName+ '"' + " was found" );

            } catch (NullPointerException ex) {
                movieSearchView.setMovieSuccessDisplay("Error!");
            }
        }
    }

    class SelectShowtimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String showtime_selected;

            try {
                showtime_selected = movieSearchView.getShowtime();
                showtimes = movieModel.getShowtimeVerification(showtime_selected);
                
                movieSearchView.setShowtimeSuccessDisplay("Showtime " + showtime_selected + " was successfully selected");
            
            } catch (NullPointerException ex) {
                movieSearchView.setShowtimeSuccessDisplay("Error!");
            }
        }
    }
    class SearchShowtimesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//        	String showtime_selected;
            ArrayList<String> availableShowtimes;
            try {
            	availableShowtimes = movieModel.returnShowtimesForMovie();
            	
                StringBuffer sb = new StringBuffer();
			      
			      for (String s : availableShowtimes) {
			         sb.append(s);
			         sb.append("\n");
			      }
			      String availableShowtimesString = sb.toString();
                movieSearchView.setShowtimesDisplay(availableShowtimesString);

            } catch (NullPointerException ex) {
                movieSearchView.setShowtimesDisplay("Error!");
            }
        }
    }

    
    
    class SearchSeatsListener implements ActionListener{
    	 @Override
         public void actionPerformed(ActionEvent e) {
    		 seatView = new SeatView();
//    		 seatController = new SeatController(null, null, thisMovieController);
    		 seatView.setVisible(true);
//				seatController.getView().setVisible(true);
//				movieSearchView.setVisible(false);
    	 }
    }
}

