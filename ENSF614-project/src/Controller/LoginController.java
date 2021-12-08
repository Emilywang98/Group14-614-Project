package Controller;
import View.Login;
import Model.LoginModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Connects the login view to login model
 */
public class LoginController {

    private Login login;
    private LoginModel model;
    private ArrayList<String> loginInfo;
    private UserController userController;

    public LoginController(Login login, LoginModel model){
        this.login = login;
        this.model = model;
        login.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String username = login.getUserName();
                String password = login.getPassword();

                loginInfo = model.getVerification(username, password);

                login.displayPlainMessage("Login", "Login Successful");
                login.getFrame().setVisible(false);
                userController = new UserController(loginInfo);
            } // Login was not successful, catches the error and displays error message
            catch (NumberFormatException e1){
                login.displayErrorMessage("ERROR, try again!");
            }
            catch(NullPointerException e2){
                login.displayErrorMessage("ERROR, try again!");
            } catch (Exception exception) {
                login.displayErrorMessage("ERROR, try again!");
            }
        }
    }
    public ArrayList<String> getLoginInfo(){
        return loginInfo;
    }
}

