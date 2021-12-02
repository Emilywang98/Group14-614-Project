package Controller;
import View.Login;
import Model.LoginModel;
import Controller.TheatreController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    Login login;
    TheatreView theatre;

    public LoginController(Login login){
        this.login = login;
        this.theatre = theatre;
    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String username = login.getUserName();
                String password = login.getPassword();

                login.displayPlainMessage("Login", "Login Successful");
            } // Login was not successful
            catch (NumberFormatException e1){
                login.displayErrorMessage("ERROR!");
            }
            catch(NullPointerException e2){
                login.displayErrorMessage("ERROR!");
            }
        }

        }
}

