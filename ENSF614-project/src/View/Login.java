package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for logging in
 */
public class Login extends JFrame implements ActionListener{
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private JButton guestButton = new JButton("Continue as Guest");
    private JTextField nameText = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel password;
    private Registration registerPage;

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
        password = new JLabel("Password: ");
        password.setBounds(10, 50, 80, 25);
        panel.add(password);

        //add password field to panel
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 50, 165, 25);
        panel.add(passwordField);

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
            registerPage = new Registration();
            registerPage.displayGUI();
        }

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
        return password.getText();
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

