package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Registration extends JFrame{
    private JLabel firstName = new JLabel("First Name: ");
    private JLabel lastName = new JLabel("Last Name: ");
    private JLabel address = new JLabel("Home Address: ");
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel cardNo = new JLabel("Card Number: ");
    private JLabel cardExp = new JLabel("Card Exp Date: ");



    private JLabel cardCvv = new JLabel("Card CVV: ");

    private JTextField firstNameText = new JTextField(10);
    private JTextField lastNameText = new JTextField(10);
    private JTextField addressText = new JTextField(10);
    private JTextField usernameText = new JTextField(10);
    private JTextField passwordText = new JTextField(10);
    private JTextField emailText = new JTextField(10);
    private JTextField cardNoText = new JTextField(10);
    private JTextField cardExpText = new JTextField(10);
    private JTextField cardCvvText = new JTextField(10);

    private Container c;
    private JLabel title;
    private JLabel cardTitle;
    private JComboBox month;
    private JComboBox year;
    private JButton submit;

    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = {"2021", "2022", "2023", "2024", "2025", "2026"};



    public void displayGUI(){
        setTitle("Registration Form");
        setBounds(300, 90, 600, 650);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        c.add(title);


        //first name
        firstName.setFont(new Font("Arial", Font.PLAIN, 15));
        firstName.setSize(80, 20);
        firstName.setLocation(120, 100);
        c.add(firstName);
        firstNameText.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameText.setSize(250, 20);
        firstNameText.setLocation(230, 100);
        c.add(firstNameText);

        //last name
        lastName.setFont(new Font("Arial", Font.PLAIN, 15));
        lastName.setSize(80, 20);
        lastName.setLocation(120, 150);
        c.add(lastName);
        lastNameText.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameText.setSize(250, 20);
        lastNameText.setLocation(230, 150);
        c.add(lastNameText);

        address.setFont(new Font("Arial", Font.PLAIN, 15));
        address.setSize(120, 20);
        address.setLocation(120, 200);
        c.add(address);
        addressText.setFont(new Font("Arial", Font.PLAIN, 15));
        addressText.setSize(250, 20);
        addressText.setLocation(230, 200);
        c.add(addressText);


        username.setFont(new Font("Arial", Font.PLAIN, 15));
        username.setSize(120, 20);
        username.setLocation(120, 250);
        c.add(username);
        usernameText.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameText.setSize(250, 20);
        usernameText.setLocation(230, 250);
        c.add(usernameText);

        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setSize(120, 20);
        password.setLocation(120, 300);
        c.add(password);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordText.setSize(250, 20);
        passwordText.setLocation(230, 300);
        c.add(passwordText);


        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setSize(120, 20);
        email.setLocation(120, 350);
        c.add(email);
        emailText.setFont(new Font("Arial", Font.PLAIN, 15));
        emailText.setSize(250, 20);
        emailText.setLocation(230, 350);
        c.add(emailText);


        //card info
        cardTitle = new JLabel("Card Information");
        cardTitle.setFont(new Font("Arial", Font.PLAIN, 23));
        cardTitle.setSize(300, 30);
        cardTitle.setLocation(230, 400);
        c.add(cardTitle);

        cardNo.setFont(new Font("Arial", Font.PLAIN, 15));
        cardNo.setSize(120, 20);
        cardNo.setLocation(120, 450);
        c.add(cardNo);
        cardNoText.setFont(new Font("Arial", Font.PLAIN, 15));
        cardNoText.setSize(250, 20);
        cardNoText.setLocation(230, 450);
        c.add(cardNoText);

        cardExp.setFont(new Font("Arial", Font.PLAIN, 15));
        cardExp.setSize(120, 20);
        cardExp.setLocation(120, 500);
        c.add(cardExp);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(230, 500);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(280, 500);
        c.add(year);


        cardCvv.setFont(new Font("Arial", Font.PLAIN, 15));
        cardCvv.setSize(120, 20);
        cardCvv.setLocation(350, 500);
        c.add(cardCvv);
        cardCvvText.setFont(new Font("Arial", Font.PLAIN, 15));
        cardCvvText.setSize(60, 20);
        cardCvvText.setLocation(420, 500);
        c.add(cardCvvText);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(235, 550);
//        submit.addActionListener(this);
        c.add(submit);
        setVisible(true);
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getCardNo() {
        return cardNo.getText();
    }

    public String getCardExp() {
        return cardExp.getText();
    }

    public String getCardCvv() {
        return cardCvv.getText();
    }

    public void addRegistrationListener(ActionListener listenForRegister){
        submit.addActionListener(listenForRegister);
    }

    public void displayPlainMessage(String titleMessage,String plainMessage){
        JOptionPane.showMessageDialog(this, plainMessage, titleMessage, JOptionPane.PLAIN_MESSAGE);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }


}
