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

/**
 * SqlDatabaseConnection class helps us connect to the database with generic selection, insert, update, and delete
 * statements. All model classes take advantage of this class.
 *
 */

public class SqlDatabaseConnection {

	private Connection connection;

	public SqlDatabaseConnection() throws ClassNotFoundException {
		
		//connection is established with JDBC
		
		// ***** ALL USERS MUST CREATE AN SQL PROFILE WITH USERNAME: "user" AND PASSWORD: "12345"
		// see README for further mySQL instructions.
		
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/MOVIETHEATRE";
		String name = "user";
		String pass = "12345";

		try {
			connection = DriverManager.getConnection(connectionUrl, name, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generic retrieval query that can take any string from the model classes to be queried.
	 * 
	 */
	public ArrayList<ArrayList<String>> doRetrievalQuery(String query) {

		ResultSet resultSet = null;

		try (PreparedStatement pStat = connection.prepareStatement(query);) {

			// Create and execute a SELECT SQL statement

			resultSet = pStat.executeQuery();

			ResultSetMetaData rsmd = resultSet.getMetaData();

			ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

			if (!resultSet.next()) {
//				System.out.println("No records found");

			}
               else {
			int i = 0;
			
			
			// parsing the retrieved records into a matrix
			do {
				ArrayList<String> tempRow = new ArrayList<String>();

				for (int j = 1; j < rsmd.getColumnCount() + 1; j++) {
					tempRow.add(resultSet.getString(j));
				}

				matrix.add(tempRow);
				i++;

			} while (resultSet.next());
               }
			
			return matrix;
		} catch (SQLException e) {
			System.err.println("Your query didn't return anything: " + e.getMessage());
			;
		}

		return null;

	}
	
	
	/**
	 * Generic insert query that requires a table name and the touple to be entered.
	 * 
	 */
	public boolean doInsertQuery(String tableName, ArrayList<String> touple) {
		
		// Create and execute an insert SQL statement
		String queryString = "INSERT INTO " + tableName + " VALUES ('" + touple.get(0);

		for (int i = 1; i < touple.size(); i++) {
			queryString += "', '" + touple.get(i);
		}
		
		queryString += "');";

		try (PreparedStatement pStat = connection.prepareStatement(queryString);) {

			pStat.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Touple not inserted into " + tableName + ": " + e.getMessage());
			;
			return false;
		}

	}
	
	/**
	 * Generic update query that requires a table name and the update specifications.
	 * 
	 */
	public boolean doUpdateQuery(String tableName, String columnName, String replacement, String conditionColumnName, String condition) {
		
		// Create and execute an update SQL statement
		String queryString = "UPDATE " + tableName + 
								"\nSET " + columnName + "=" + replacement +
									"\nWHERE " + conditionColumnName + "=" + condition + ";";

		try (PreparedStatement pStat = connection.prepareStatement(queryString);) {

			pStat.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Touple not updated in " + tableName + ": " + e.getMessage());
			return false;
		}

	}
	
	/**
	 * Generic delete query that requires a table name and the delete specifications.
	 * 
	 */
	public boolean doDeleteQuery(String tableName, String conditionColumnName, String condition) {
		
		// Create and execute a delete SQL statement
		String queryString = "DELETE FROM " + tableName + " WHERE " + conditionColumnName + "=" + condition + ";";
		
		try (PreparedStatement pStat = connection.prepareStatement(queryString);) {

			pStat.execute();

			return true;
		} catch (SQLException e) {
			System.err.println("Touple not deleted in " + tableName + ": " + e.getMessage());
			;
			return false;
		}

	}

}