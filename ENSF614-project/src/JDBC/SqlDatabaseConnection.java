package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlDatabaseConnection {

    private Connection connection;
//    private String query;

    public SqlDatabaseConnection() throws ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/MOVIETHEATRE";
//          String connectionUrl ="jdbc:mysql://localhost/MOVIETHEATRE";
//        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String name = "user";
        String pass = "12345";
        
        try {
			connection = DriverManager.getConnection(connectionUrl, name, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public ArrayList<ArrayList<String>> doRetrievalQuery(String query) {
    	
    	ResultSet resultSet = null;
    	
        try (
        		PreparedStatement pStat = connection.prepareStatement(query);
        		) {

               // Create and execute a SELECT SQL statement
        		
               resultSet = pStat.executeQuery();
               

               ResultSetMetaData rsmd = resultSet.getMetaData();
               
               ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
               
               // Print results from select statement
               
               if (!resultSet.next()) {
            	   System.out.println("No records found");

               }
//               else {
            	   int i = 0;
            	   do {
            		   ArrayList<String> tempRow = new ArrayList<String>();
            		   
            		   for (int j = 1; j < rsmd.getColumnCount()+1; j++) {
            			   tempRow.add(resultSet.getString(j));
            		   }
            		   
            		   matrix.add(tempRow);
            		   i++;
            		   
            	   } while (resultSet.next());
//               }
               
//               System.out.println();
//               System.out.println(matrix.get(1).get(2));
          
               
               return matrix;
           }
	       catch (SQLException e) {
	           System.err.println("Your query didn't return anything: " + e.getMessage());;
	       }

        
        return null;

    }
    
  public boolean doInsertQuery(String tableName, ArrayList<String> touple) {
	
	ResultSet columnNameSet = null;
	ResultSet resultSet = null;
	
	String queryString = "INSERT INTO " + tableName + " VALUES ('" + touple.get(0);
	
	for (int i = 1; i < touple.size(); i++) {
		queryString += "', '" + touple.get(i);
	}
	
	queryString += "');";
	
	System.out.println(queryString);
	
    try (
    		PreparedStatement pStat = connection.prepareStatement(queryString);
    		) {

           pStat.executeUpdate();
           
           return true;
    	}catch (SQLException e) {
    		System.err.println("Touple not inserted into " + tableName +  ": " + e.getMessage());;
           return false;
       }

}


}