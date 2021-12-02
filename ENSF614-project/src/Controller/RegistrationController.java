package Controller;
import View.Registration;
import Model.RegistrationModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationController {
    Registration register;
    RegistrationModel model;

    public RegistrationController(Registration r, RegistrationModel m){
        this.register = r;
        this.model = m;
        register.addRegistrationListener(new RegistrationListener());
    }
    class RegistrationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String name = register.getFirstName();
                String lastName = register.getLastName();
                String username = register.getUsername();
                String password = register.getPassword();
                String email = register.getEmail();
                String address = register.getAddress();
                String cardNo = register.getCardNo();
                String cardExp = register.getCardExp();
                String cardCvv = register.getCardCvv();


                register.displayPlainMessage("Registration", "Registration Successful");
            } // Login was not successful
            catch (NumberFormatException e1){
                register.displayErrorMessage("ERROR!");
            }
            catch(NullPointerException e2){
                register.displayErrorMessage("ERROR!");
            }
        }

    }

}
