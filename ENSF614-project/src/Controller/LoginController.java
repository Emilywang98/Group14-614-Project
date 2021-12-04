package Controller;
import View.Login;
import Model.LoginModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController {

    Login login;
    LoginModel model;
    ArrayList<String> loginInfo;

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

//                else{
//                    login.displayPlainMessage("Login", "Login Unsuccessful");
//                }
            } // Login was not successful
            catch (NumberFormatException e1){
                login.displayErrorMessage("ERROR!");
            }
            catch(NullPointerException e2){
                login.displayErrorMessage("ERROR!");
            }
        }

    }
    public ArrayList<String> getLoginInfo(){
        return loginInfo;
    }
}

