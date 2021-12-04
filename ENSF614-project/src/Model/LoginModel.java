package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class LoginModel {
	
	SqlDatabaseConnection myConnection;
	String username;
	String password;

	//our database should be in RegisteredUser class
	ArrayList<String> info;

    public LoginModel() throws ClassNotFoundException {
    	myConnection = new SqlDatabaseConnection();
    }
    
    public ArrayList<String> getVerification(String username, String password) {

		//query the username and password
//		System.out.println("SELECT Username, Password FROM REGISTEREDUSER WHERE Username=\""+username+"\" AND Password =\""+password+"\"");
    	ArrayList<ArrayList<String>> matrix = myConnection.doQuery("SELECT Username, Password FROM REGISTEREDUSER WHERE Username=\""+username+"\" AND Password =\""+password+"\"");

		if(matrix.get(0).get(0).equals(username) && matrix.get(0).get(1).equals(password)){
//			System.out.println("Login Successful!");
			ArrayList<String> loginInfo = new ArrayList();
			loginInfo.add(username);
			loginInfo.add(password);
			return loginInfo;
		}
		else{
			throw new NullPointerException();
		}

    }
}
