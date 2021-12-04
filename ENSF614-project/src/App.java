import Controller.LoginController;
import View.Login;
import Model.LoginModel;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		Login app = new Login();
		LoginModel model = new LoginModel();
		LoginController controller = new LoginController(app, model);
		app.runApp();
	}

}
