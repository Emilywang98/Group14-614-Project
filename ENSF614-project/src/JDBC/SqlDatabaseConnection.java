package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabaseConnection {

    private Connection connection;
//    private String query;

    public SqlDatabaseConnection(){
        
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/MOVIETHEATRE";
        String name = "root";
        String pass = "PASSWORD";
        
        try {
			connection = DriverManager.getConnection(connectionUrl, name, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public String doQuery(String query) {
    	
    	ResultSet resultSet = null;
    	
        try (
                Statement statement = connection.createStatement();) {

               // Create and execute a SELECT SQL statement
               resultSet = statement.executeQuery(query);
               
               String s = "";
               // Print results from select statement
               while (resultSet.next()) {
                   s += resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3);
               }
               
               return s;
           }
	       catch (SQLException e) {
	           e.printStackTrace();
	       }
        
        return "this didnt work";

    }


}