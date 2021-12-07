import Controller.MovieController;
import Controller.SeatController;
import Controller.TheatreController;
import Model.MovieModel;
import Model.SeatModel;
import Model.TheatreModel;
import View.MovieSearchView;
import View.SeatView;
import View.TheatreView;

public class MovieSeatTester {
	

		public static void main(String[] args) throws ClassNotFoundException {
			
//			MovieController movieController = new MovieController();
//			seatController.getView().setVisible(true);
			
//			SeatController seatController = new SeatController();
//			seatController.getView().setVisible(true);
			
			TheatreModel theatreModel = new TheatreModel();
			TheatreView theatreView = new TheatreView();
			TheatreController theatreController = new TheatreController(theatreView,theatreModel);
			
			

			
		}

	}

