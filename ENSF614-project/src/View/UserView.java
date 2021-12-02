package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserView extends JFrame implements ActionListener{

    private JLabel userName = null;
    private JLabel userPwd = null;
    private JLabel FName = null;
    private JLabel LName = null;
    private JLabel Email = null;
    private JLabel Address= null;
    private JLabel cardNo = null;
    private JLabel cvv = null;
    private JLabel expDate = null;

    private JButton bookBtn =null;
    private JButton cancelBtn = null;
    
    private TheatreView theatre = null;
    private PaymentView payment = null;

    
    public void runApp(){

        bookBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        displayGUI();
    }
    
    public void displayGUI() {
        this.setTitle("Registered User Info Page");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 250);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title = new JLabel ("Registered User Info Page");
        title.setBounds(150, 50, 400, 50);
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        this.add(title);

        JLabel userTip = new JLabel ("User Name:");
        userTip.setBounds(50, 100, 250, 25);
        userTip.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(userTip);

        userName = new JLabel ("Erika97");
        userName.setBounds(170, 100, 250, 25);
        userName.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(userName);

        JLabel pwdTip = new JLabel ("User Password:");
        pwdTip.setBounds(50, 120, 250, 25);
        pwdTip.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(pwdTip);

        userPwd = new JLabel ("123456");
        userPwd.setBounds(170, 120, 250, 25);
        userPwd.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(userPwd);


        JLabel fName = new JLabel ("First name:");
        fName.setBounds(50, 140, 250, 25);
        fName.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(fName);

        FName = new JLabel ("Erika");
        FName.setBounds(170, 140, 250, 25);
        FName.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(FName);

        JLabel lName = new JLabel ("Last name:");
        lName.setBounds(50, 160, 250, 25);
        lName.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(lName);

        LName = new JLabel ("Wang");
        LName.setBounds(170, 160, 250, 25);
        LName.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(LName);

        JLabel email = new JLabel ("Email address:");
        email.setBounds(50, 180, 250, 25);
        email.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(email);

        Email = new JLabel ("erikawang97@gmail.com");
        Email.setBounds(170, 180, 250, 25);
        Email.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(Email);

        JLabel address = new JLabel ("Home address");
        address.setBounds(50, 200, 250, 25);
        address.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(address);

        Address = new JLabel ("2500 University Dr NW, Calgary, AB T2N 1N4");
        Address.setBounds(170, 200, 400, 25);
        Address.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(Address);

        JLabel creditNo = new JLabel ("Credit card number:");
        creditNo.setBounds(50, 220, 250, 25);
        creditNo.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(creditNo);

        cardNo = new JLabel ("4485144470717028");
        cardNo.setBounds(200, 220, 400, 25);
        cardNo.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(cardNo);

        JLabel creditCVV = new JLabel ("Credit card CVV:");
        creditCVV.setBounds(50, 240, 250, 25);
        creditCVV.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(creditCVV);

        cvv = new JLabel ("905");
        cvv.setBounds(200, 240, 400, 25);
        cvv.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(cvv);

        JLabel creditDate = new JLabel ("Credit card expiration date:");
        creditDate.setBounds(50, 260, 250, 25);
        creditDate.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(creditDate);

        expDate = new JLabel ("2025/12/31");
        expDate.setBounds(250, 260, 400, 25);
        expDate.setFont(new Font("Courier New", Font.BOLD, 12));
        this.add(expDate);

        bookBtn = new JButton("Book ticket");
        bookBtn.setBounds(100, 300, 180, 25);
        this.add(bookBtn);

        cancelBtn = new JButton("Cancel ticket");
        cancelBtn.setBounds(300, 300, 180, 25);
        this.add(cancelBtn);


        JLabel announcement = new JLabel ("*Pre-public announcements will be sent to your email address.");
        announcement.setBounds(50,330,450,25);
        this.add(announcement);

        this.setVisible(true);
    }

    public String getUserName() {
        return userName.getText();
    }


    public String getUserPwd() {
        return userPwd.getText();
    }


    public String getFName() {
        return FName.getText();
    }


    public String getLName() {
        return LName.getText();
    }

    public String getEmail() {
        return Email.getText();
    }

    public String getAddress() {
        return Address.getText();
    }

    public String getCardNo() {
        return cardNo.getText();
    }


    public String getCvv() {
        return cvv.getText();
    }

    public String getExpDate() {
        return expDate.getText();
    }

    public void displayMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void addBookListener (ActionListener listenForBookButton) {
        bookBtn.addActionListener(listenForBookButton);
    }

    public void addCancelListener (ActionListener listenForCancelButton) {
        cancelBtn.addActionListener(listenForCancelButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	 if (e.getSource() == bookBtn) {
             theatre = new TheatreView();
             theatre.displayGUI();
         }
    	 if (e.getSource() == cancelBtn) {
             payment = new PaymentView();
         }

    }
    
    public static void main(String[] args) {
    	UserView userview = new UserView();
    	userview.displayGUI();
	}


}



