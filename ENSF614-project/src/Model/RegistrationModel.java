package Model;

import JDBC.SqlDatabaseConnection;

import java.util.ArrayList;

/**
 * Registration model that adds the new user's information to the database
 */
public class RegistrationModel {
    private SqlDatabaseConnection myConnection;
    private ArrayList<String> newRegistration = new ArrayList<String>();

    public RegistrationModel() throws ClassNotFoundException {
        myConnection = new SqlDatabaseConnection();

    }
    public ArrayList<String> addNewUser(String firstName, String lastName, String username, String password, String email, String address, String cardNumber, String cardCvv, String cardExp){
        //add info to arraylist
        newRegistration.add(username);
        newRegistration.add(password);
        newRegistration.add(firstName);
        newRegistration.add(lastName);
        newRegistration.add(address);
        newRegistration.add(email);
        newRegistration.add(cardNumber);
        newRegistration.add(cardCvv);
        newRegistration.add(cardExp);

        String testTableName = "REGISTEREDUSER";

        boolean postQuery = myConnection.doInsertQuery(testTableName, newRegistration);

        //post the new user to database
        if(postQuery){
            return newRegistration;
        }else{
            throw new NullPointerException();
        }


    }



}
