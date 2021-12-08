package Model;
import JDBC.SqlDatabaseConnection;
import java.util.ArrayList;

/*
 * This class contains logic of registered user where it receives username and
 * password from login. Then it pulls the registered user's information and display
 * them on the screen. It also provides choices for registered user to pay their annual
 * fee, view announcements that will be sent to their email, select theatre and cancel
 * ticket.
 * 
 */

public class UserModel {
	//create jdbc to database connection
    private SqlDatabaseConnection myConnection;
    
    //attributes for users
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String cardNumber;
    private String cardCvv;
    private String cardExp;
    
  
    //connect to jdbc
    public UserModel() throws ClassNotFoundException {
    	myConnection = new SqlDatabaseConnection();
    }
    
    //return an arraylist of registered user's information based on their information
    public ArrayList<ArrayList<String>> showUserInfo(String username, String password) {
    	ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT * FROM REGISTEREDUSER WHERE Username=\""+username+"\" AND Password =\""+password+"\"");
		//added all attributes to arraylist and passed this arraylist to the userview
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
    
}


