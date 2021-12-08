package Controller;

import View.UserView;
import Model.UserModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UserController {
	private UserView view;
	private UserModel model;
	
	private String fName;
	private String lName;
	private String email;
	private String address;
	private String creditNo;
	private String cvv;
	private String expDate;
	
	private ArrayList<ArrayList<String>> matrix;
	
	 
	public UserController(ArrayList<String> loginInfo){
	    try {
			String username = loginInfo.get(0);
			String userPwd = loginInfo.get(1);
			this.model = new UserModel();
			matrix = model.showUserInfo(username, userPwd);
			this.view = new UserView();
			this.setAll(matrix);
			view.displayGUI(username, userPwd, fName,lName, address, email,creditNo,cvv, expDate);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    view.addBookListener(new BookListener());
	    view.addCancelListener(new CancelListener());
	    view.addPayFeeListener(new PayFeeListener());
	 }

	
	public UserView getView() {
		return view;
	}
	
	public void setAll(ArrayList<ArrayList<String>> matrix) {
		fName = matrix.get(0).get(2);
		lName = matrix.get(0).get(3);
		address = matrix.get(0).get(4);
		email = matrix.get(0).get(5);
		creditNo = matrix.get(0).get(6);
		cvv = matrix.get(0).get(7);
		expDate = matrix.get(0).get(8);
	}
	
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public String getCardNumber() {
		return creditNo;
	}
	
	public String getCardCvv() {
		return cvv;
	}
	
	public String getCardExp() {
		return expDate;
	}
	 
	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	class BookListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			try {
				
				
			} catch (NumberFormatException e1){
                view.displayMessage("ERROR!");
            }
            catch(NullPointerException e2){
                view.displayMessage("ERROR!");
            }
		}
		 
	 }
	
	class PayFeeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.displayMessage("Your account is charged for 20 membership fee.");
		}
		
	}
	 
	class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				
			} catch (NumberFormatException e1){
                view.displayMessage("ERROR!");
            }
            catch(NullPointerException e2){
                view.displayMessage("ERROR!");
            }
		}
		 
	 }
}
	 