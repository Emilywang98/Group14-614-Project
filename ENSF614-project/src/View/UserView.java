package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import View.Login;
import Controller.TheatreController;
import Controller.UserController;
import Model.TheatreModel;
import Model.UserModel;

public class UserView extends JFrame implements ActionListener {

	private JLabel userName;
	private JLabel userPwd;
	private JLabel FName;
	private JLabel LName;
	private JLabel Email;
	private JLabel Address;
	private JLabel cardNo;
	private JLabel cvv;
	private JLabel expDate;

	private JButton bookBtn = new JButton("Book ticket");
	private JButton cancelBtn = new JButton("Cancel ticket");
	private JButton payFeeBtn = new JButton("Pay Annual Fee");

	private TheatreView theatre;
	private PaymentView payment;

	public void runApp() {
		bookBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		payFeeBtn.addActionListener(this);
	}

	public void displayGUI(String username, String password, String firstName, String lastName, String homeAddress,
			String emailAdd, String cardNumb, String cardCvv, String cardExpDate) {
		this.setTitle("Registered User Info Page");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 250);
		this.setResizable(false);
		this.setLayout(null);

		JLabel title = new JLabel("Registered User Info Page");
		title.setBounds(150, 50, 400, 50);
		title.setFont(new Font("Courier New", Font.BOLD, 20));
		this.add(title);

		JLabel userTip = new JLabel("User Name:");
		userTip.setBounds(50, 100, 250, 25);
		userTip.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(userTip);

		userName = setUserName(username);

		userName.setBounds(170, 100, 250, 25);
		userName.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(userName);

		JLabel pwdTip = new JLabel("User Password:");
		pwdTip.setBounds(50, 120, 250, 25);
		pwdTip.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(pwdTip);

		userPwd = setUserPwd(password);
		userPwd.setBounds(170, 120, 250, 25);
		userPwd.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(userPwd);

		JLabel fName = new JLabel("First name:");
		fName.setBounds(50, 140, 250, 25);
		fName.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(fName);

//        FName = setFName(controller.getFName());
		FName = setFName(firstName);
		FName.setBounds(170, 140, 250, 25);
		FName.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(FName);

		JLabel lName = new JLabel("Last name:");
		lName.setBounds(50, 160, 250, 25);
		lName.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(lName);

//        LName = setLName(controller.getLName());
		LName = setLName(lastName);
		LName.setBounds(170, 160, 250, 25);
		LName.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(LName);

		JLabel email = new JLabel("Email address:");
		email.setBounds(50, 180, 250, 25);
		email.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(email);

//        Email = setEmail(controller.getEmail());
		Email = setEmail(emailAdd);
		Email.setBounds(170, 180, 250, 25);
		Email.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(Email);

		JLabel address = new JLabel("Home address");
		address.setBounds(50, 200, 250, 25);
		address.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(address);

//        Address = setAddress(controller.getAddress());
		Address = setAddress(homeAddress);
		Address.setBounds(170, 200, 400, 25);
		Address.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(Address);

		JLabel creditNo = new JLabel("Credit card number:");
		creditNo.setBounds(50, 220, 250, 25);
		creditNo.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(creditNo);

		cardNo = setCardNo(cardNumb);
//        cardNo = setCardNo(controller.getCardNumber());
		cardNo.setBounds(200, 220, 400, 25);
		cardNo.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(cardNo);

		JLabel creditCVV = new JLabel("Credit card CVV:");
		creditCVV.setBounds(50, 240, 250, 25);
		creditCVV.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(creditCVV);

//        cvv = setCvv(controller.getCardCvv());
		cvv = setCvv(cardCvv);
		cvv.setBounds(200, 240, 400, 25);
		cvv.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(cvv);

		JLabel creditDate = new JLabel("Credit card expiration date:");
		creditDate.setBounds(50, 260, 250, 25);
		creditDate.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(creditDate);

//        expDate = setExpDate(controller.getCardExp());
		expDate = setExpDate(cardExpDate);
		expDate.setBounds(250, 260, 400, 25);
		expDate.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(expDate);

		bookBtn.setBounds(100, 280, 180, 25);
		this.add(bookBtn);

		cancelBtn.setBounds(300, 280, 180, 25);
		this.add(cancelBtn);

		payFeeBtn.setBounds(100, 300, 180, 25);
		this.add(payFeeBtn);

		JLabel announcement = new JLabel("*Pre-public announcements will be sent to your email address.");
		announcement.setBounds(50, 330, 450, 25);
		this.add(announcement);

		this.setVisible(true);
	}

	public JLabel setUserName(String str) {
		return userName = new JLabel(str);
	}

	public JLabel setUserPwd(String str) {
		return userPwd = new JLabel(str);
	}

	public JLabel setFName(String str) {
		return FName = new JLabel(str);
	}

	public JLabel setLName(String str) {
		return LName = new JLabel(str);
	}

	public JLabel setEmail(String str) {
		return Email = new JLabel(str);
	}

	public JLabel setAddress(String str) {
		return Address = new JLabel(str);
	}

	public JLabel setCardNo(String str) {
		return cardNo = new JLabel(str);
	}

	public JLabel setCvv(String str) {
		return cvv = new JLabel(str);
	}

	public JLabel setExpDate(String str) {
		return expDate = new JLabel(str);
	}

	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void addBookListener(ActionListener listenForBookButton) {
		bookBtn.addActionListener(listenForBookButton);
	}

	public void addPayFeeListener(ActionListener listenForPayFeeButton) {
		payFeeBtn.addActionListener(listenForPayFeeButton);
	}

	public void addCancelListener(ActionListener listenForCancelButton) {
		cancelBtn.addActionListener(listenForCancelButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bookBtn) {
			TheatreView theatreView = new TheatreView();
			TheatreModel model = new TheatreModel();
			TheatreController controller = new TheatreController(theatreView, model);
			theatreView.setVisible(true);
		}

		if (e.getSource() == cancelBtn) {
			payment = new PaymentView();
			payment.setVisible(true);
		}
	}

}
