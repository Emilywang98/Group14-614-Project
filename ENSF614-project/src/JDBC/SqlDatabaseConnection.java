package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabaseConnection {

    private static String query;
//    private String query;

    public SqlDatabaseConnection(String q){
        this.query = q;
    }


    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

        ResultSet resultSet = null;
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        try (Connection connection = DriverManager.getConnection(url, "root", PASSWORD);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
            resultSet = statement.executeQuery(query);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}