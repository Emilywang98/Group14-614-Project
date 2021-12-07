package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.RegistrationModel;
import Controller.RegistrationController;
import View.NavigationView;

/**
 * View for logging in
 */
public class Login extends JFrame implements ActionListener{
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private JButton guestButton = new JButton("Continue as Guest");
    private JTextField nameText = new JTextField();
    private JTextField passwordText = new JPasswordField();

    private Registration registerPage;
    private RegistrationController registerController;
    private RegistrationModel registerModel;
    private NavigationView navigationPage;
    private UserView userPage;

    public void runApp(){

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        guestButton.addActionListener(this);

        displayGUI();
    }

    public void displayGUI(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        //configure the frame
        frame.setSize(350, 200);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        //name label and textbox
        JLabel nameLabel = new JLabel("Username: ");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);


        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

        //add password label to panel
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        //add password field to panel
        passwordText = new JPasswordField();
        passwordText.setBounds(150, 50, 165, 25);
        panel.add(passwordText);

        loginButton.setBounds(100, 90, 100, 25);
        panel.add(loginButton);

        registerButton.setBounds(40, 120, 100, 25);
        panel.add(registerButton);

        guestButton.setBounds(140, 120, 150, 25);
        panel.add(guestButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // register pressed
        if (e.getSource() == registerButton) {
            registerController = new RegistrationController();
        }

        // register pressed
        if (e.getSource() == guestButton) {
            navigationPage = new NavigationView();
            navigationPage.displayGUI();
        }
    }


    public void addLoginListener(ActionListener listenForLogin){
        loginButton.addActionListener(listenForLogin);
    }

    /**
     * Returns Username
     * @return
     */
    public String getUserName() {
        return nameText.getText();
    }

    /**
     * Returns the password
     * @return
     */
    public String getPassword() {
        return passwordText.getText();
    }

    /**
     * Displays an error message in a dialog box.
     * @param errorMessage the error message
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * Displays a plain message in a dialog box
     * @param titleMessage title of the dialog box
     * @param plainMessage the plain message
     */
    public void displayPlainMessage(String titleMessage,String plainMessage){
        JOptionPane.showMessageDialog(this, plainMessage, titleMessage, JOptionPane.PLAIN_MESSAGE);
    }
}

