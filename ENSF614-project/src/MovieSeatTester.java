import Controller.MovieController;
import Controller.SeatController;
import Model.MovieModel;
import Model.SeatModel;
import View.MovieSearchView;
import View.SeatView;

public class MovieSeatTester {
	

		public static void main(String[] args) throws ClassNotFoundException {
			
			MovieModel movieModel = new MovieModel();
			MovieSearchView movieSearchView = new MovieSearchView();
			MovieController movieController = new MovieController(movieSearchView, movieModel);

//			movieController.getView().setVisible(true);
			
			
			SeatModel seatModel = new SeatModel();
			SeatView seatView = new SeatView();

			SeatController seatController = new SeatController(seatView, seatModel);

//			seatController.getView().setVisible(true);
			
//			Login app = new Login();
//			LoginModel model = new LoginModel();
//			LoginController controller = new LoginController(app, model);
		}

	}

