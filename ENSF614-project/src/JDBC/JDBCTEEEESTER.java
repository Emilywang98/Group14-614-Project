package JDBC;

import java.util.ArrayList;

public class JDBCTEEEESTER {

	public static void main(String[] args) {
		ArrayList<String> testTouple = new ArrayList<String>();
		String testTableName = "REGISTEREDUSER";
		testTouple.add("greg123456789");
		testTouple.add("12345");
		testTouple.add("John Smith");
		testTouple.add(" address goes here");
		testTouple.add(" email here");
		testTouple.add(" big number here");
		testTouple.add("909");
		

		try {
			SqlDatabaseConnection myConnection = new SqlDatabaseConnection();
			myConnection.doInsertQuery(testTableName, testTouple);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
