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
	
	
	public static void main(String[] args) {
		LoginModel loginModel = new LoginModel();
		ArrayList<ArrayList<String>> matrix = loginModel.getVerification();
	}
	
    public LoginModel(){
    	myConnection = new SqlDatabaseConnection();
    }
    
    public ArrayList<ArrayList<String>> getVerification() {
    	ArrayList<ArrayList<String>> matrix = myConnection.doQuery("SELECT Username, Password FROM REGISTEREDUSER WHERE Name=\"Gregory Slowski\"");
//    	ArrayList<ArrayList<String>> matrix = myConnection.doQuery("SELECT * FROM REGISTEREDUSER");
    	return matrix;
    }
}
