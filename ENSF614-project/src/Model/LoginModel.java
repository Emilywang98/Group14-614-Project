package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.SqlDatabaseConnection;

public class LoginModel {
	
	SqlDatabaseConnection myConnection;
	String username;
	String password;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		LoginModel loginModel = new LoginModel();
		String s = loginModel.getVerification();
		System.out.println(s);
	}
	
    public LoginModel() throws ClassNotFoundException {
    	myConnection = new SqlDatabaseConnection();
    }
    
    public String getVerification() {
    	String s = myConnection.doQuery("SELECT * FROM REGISTEREDUSER");
    	return s;
    }
}
