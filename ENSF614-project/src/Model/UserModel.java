package Model;


import JDBC.SqlDatabaseConnection;
import Controller.UserController;

import java.util.ArrayList;

public class UserModel {
	
    private SqlDatabaseConnection myConnection;
    
    private UserController controller;
    
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String cardNumber;
    private String cardCvv;
    private String cardExp;
    
  
    
    public UserModel() throws ClassNotFoundException {
    	myConnection = new SqlDatabaseConnection();
    }
    
    public ArrayList<ArrayList<String>> showUserInfo(String username, String password) {
    	ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT * FROM REGISTEREDUSER WHERE Username=\""+username+"\" AND Password =\""+password+"\"");
		if(matrix.get(0).get(0).equals(username) && matrix.get(0).get(1).equals(password)){
			firstName = matrix.get(0).get(2);
			lastName = matrix.get(0).get(3);
			address = matrix.get(0).get(4);
			email = matrix.get(0).get(5);
			cardNumber = matrix.get(0).get(6);
			cardCvv = matrix.get(0).get(7);
			cardExp = matrix.get(0).get(8);
			return matrix;
		}
		else{
			throw new NullPointerException();
		}

    }
    
//	public String getFName() {
//		return firstName;
//	}
//	
//	public String getLName() {
//		return lastName;
//	}
//	
//	public String getAddress() {
//		return address;
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	
//	public String getCardNumber() {
//		return cardNumber;
//	}
//	
//	public String getCardCvv() {
//		return cardCvv;
//	}
//	
//	public String getCardExp() {
//		return cardExp;
//	}
	
}


