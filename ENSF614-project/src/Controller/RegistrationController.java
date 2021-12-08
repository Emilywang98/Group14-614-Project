package Controller;
import View.Registration;
import Model.RegistrationModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Registration controller to connect the registration view and model
 */
public class RegistrationController {
    private Registration register;
    private RegistrationModel model;
    private ArrayList<String> registrationInfo;

    public RegistrationController(){
        this.register = new Registration();
        register.displayGUI();
        try {
            this.model = new RegistrationModel();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
                String cardCvv = register.getCardCvv();
                String cardExp = register.getCardExp();

                //passes the new user to the model
                registrationInfo = model.addNewUser(name, lastName, username, password, email, address, cardNo, cardCvv, cardExp);

                register.displayPlainMessage("Registration", "Registration Successful");
            } // Login was not successful
            catch (NumberFormatException e1){
                register.displayErrorMessage("ERROR, try again!");
            }
            catch(NullPointerException e2){
                register.displayErrorMessage("ERROR, try again!");
            }
        }

    }

    public ArrayList<String> getRegistrationInfo(){
        return registrationInfo;
    }

}
