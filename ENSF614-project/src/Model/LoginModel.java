package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class LoginModel {
	
	private SqlDatabaseConnection myConnection;

    public LoginModel() throws ClassNotFoundException {
    	myConnection = new SqlDatabaseConnection();
    }
    
    public ArrayList<String> getVerification(String username, String password) throws Exception {

		//query the username and password
    	ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT Username, Password FROM REGISTEREDUSER WHERE Username=\""+username+"\" AND Password =\""+password+"\"");

		if(matrix.get(0).get(0).equals(username) && matrix.get(0).get(1).equals(password)){
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
