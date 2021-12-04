package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlDatabaseConnection {

    private Connection connection;
//    private String query;

    public SqlDatabaseConnection(){
        
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/MOVIETHEATRE";
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
        		
               resultSet = pStat.executeQuery(query);
               

               ResultSetMetaData rsmd = resultSet.getMetaData();
               
               ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
               
               // Print results from select statement
               
               if (!resultSet.next()) {
            	   System.out.println("No records found");

               }
               else {
            	   int i = 0;
            	   do {
            		   ArrayList<String> tempRow = new ArrayList<String>();
            		   
            		   for (int j = 1; j < rsmd.getColumnCount()+1; j++) {
            			   tempRow.add(resultSet.getString(j));
            			   System.out.print("" + tempRow.get(j-1) + " ");
            		   }
            		   
            		   matrix.add(tempRow);
            		   System.out.println();
            		   i++;
            		   
            	   } while (resultSet.next());
               }
               
//               System.out.println();
//               System.out.println(matrix.get(1).get(2));
          
               
               return matrix;
           }
	       catch (SQLException e) {
	           e.printStackTrace();
	       }
        
        return null;

    }
    
  public boolean doUpdateQuery(String query) {
	
	ResultSet resultSet = null;
	
    try (
            Statement statement = connection.createStatement();) {

           // Create and execute a SELECT SQL statement
           resultSet = statement.executeQuery(query);
           

           ResultSetMetaData rsmd = resultSet.getMetaData();
           
           ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
           
           // Print results from select statement
           
           if (!resultSet.next()) {
        	   System.out.println("No records found");

           }
           else {
        	   int i = 0;
        	   do {
        		   ArrayList<String> tempRow = new ArrayList<String>();
        		   
        		   for (int j = 1; j < rsmd.getColumnCount()+1; j++) {
        			   tempRow.add(resultSet.getString(j));
        			   System.out.print("" + tempRow.get(j-1) + " ");
        		   }
        		   
        		   matrix.add(tempRow);
        		   System.out.println();
        		   i++;
        		   
        	   } while (resultSet.next());
           }
           
//           System.out.println();
//           System.out.println(matrix.get(1).get(2));
      
           
           return matrix;
       }
       catch (SQLException e) {
           e.printStackTrace();
       }
    
    return null;

}


}