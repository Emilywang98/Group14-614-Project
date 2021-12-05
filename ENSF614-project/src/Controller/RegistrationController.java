package Controller;
import View.Registration;
import Model.RegistrationModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationController {
    Registration register;
    RegistrationModel model;
    ArrayList<String> registrationInfo;

    public RegistrationController(Registration r, RegistrationModel m){
        this.register = r;
        this.model = m;
        register.addRegistrationListener(new RegistrationListener());
    }
    class RegistrationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(register.getCardExp());

            try {
                String name = register.getFirstName();
                String lastName = register.getLastName();
                String username = register.getUsername();
                String password = register.getPassword();
                String email = register.getEmail();
                String address = register.getAddress();
                String cardNo = register.getCardNo();
                String cardCvv = register.getCardCvv();
                String cardExp = register.getCardExp();


                registrationInfo = model.addNewUser(name, lastName, username, password, email, address, cardNo, cardCvv, cardExp);
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

    public ArrayList<String> getRegistrationInfo(){
        return registrationInfo;
    }

}
