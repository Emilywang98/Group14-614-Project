package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class SeatModel {

	SqlDatabaseConnection myConnection;
	int seatRow;
	int seatColumn;

	public SeatModel() throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}

//	    private boolean ifReserved;

	public ArrayList<ArrayList<String>> returnSeats(String showtime_selected) {
		System.out.println(myConnection
				.doRetrievalQuery("SELECT ShowtimeID FROM SHOWTIME WHERE ShowTime=\"" + showtime_selected + "\""));
		ArrayList<ArrayList<String>> showtimeID = myConnection
				.doRetrievalQuery("SELECT ShowtimeID FROM SHOWTIME WHERE ShowTime=\"" + showtime_selected + "\"");
		System.out.println(showtimeID.get(0).get(0));
		ArrayList<ArrayList<String>> seatMatrix = myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT WHERE ShowtimeID=\"" + showtimeID.get(0).get(0) + "\"");
//	    	ArrayList<String> availableSeats = new ArrayList();
//	    	for(ArrayList<String>s:seatMatrix) {
//	    		availableSeats.addAll(s);
//		    	}

		return seatMatrix;
	}

	public String getVerification(String seatRow, String seatColumn, String email) {

		ArrayList<ArrayList<String>> matrix = myConnection
				.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT WHERE SeatRow=\"" + seatRow
						+ "\" AND SeatColumn =\"" + seatColumn + "\"");
		if (!matrix.isEmpty()) {
			ArrayList<String> ticket = new ArrayList<String>();
			ticket.add(matrix.get(0).get(0));
			ticket.add("reserved");
			ticket.add(email);
			myConnection.doInsertQuery("TICKET (SeatID, `Status`, Email)", ticket);
		} else {
			throw new NullPointerException();
		}

		return matrix.get(0).get(0);

	}
}
