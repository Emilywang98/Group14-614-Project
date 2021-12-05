package Controller;

import View.UserView;
import Model.UserModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class UserController {
	
	 private UserView view;
	 private UserModel model;
	 private TheatreController theatreController;
	 private ArrayList<String> loginInfo;

	 public UserController(ArrayList<String> loginInfo){

		 this.loginInfo = loginInfo;

		 this.view = new UserView();
	     this.model = new UserModel();
	     
	     view.addBookListener(new BookListener());
	     view.addCancelListener(new CancelListener());
	 }
	 
	 public UserView getView() {
		 return view;
	 }
	 
	 class BookListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String accountName;
			String userPwd;
			String fName;
			String lName;
			String email;
			String address;
			String creditNo;
			String cvv;
			String expDate;
			try {
				accountName = view.getUserName();
				userPwd = view.getUserPwd();
				fName = view.getFName();
				lName = view.getLName();
				email = view.getEmail();
				address = view.getAddress();
				creditNo = view.getCardNo();
				cvv = view.getCvv();
				expDate = view.getExpDate();
			}catch(NumberFormatException e1) {
				view.displayMessage("Error!");
			}
		}
		 
	 }
	 
	 class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String email;
			String creditNo;
			String cvv;
			String expDate;
			// TODO Auto-generated method stub
			try {
				email = view.getEmail();
				creditNo = view.getCardNo();
				cvv = view.getCvv();
				expDate = view.getExpDate();
				
			}catch(NumberFormatException e1) {
				view.displayMessage("Error!");
			}
		}
		 
	 }
}
	 