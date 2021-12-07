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

	public ArrayList<ArrayList<String>> returnSeats(String showtimeID) {
		ArrayList<ArrayList<String>> allSeatsForTheShowtime = myConnection
				.doRetrievalQuery("SELECT SeatID, SeatRow, SeatColumn FROM SEAT WHERE ShowtimeID = \"" + showtimeID + "\"");
		
		ArrayList<ArrayList<String>> occupiedSeats = myConnection
				.doRetrievalQuery("SELECT SeatID FROM TICKET WHERE Status = 'paid' OR Status = 'reserved'");
		
		for(int i=0; i< allSeatsForTheShowtime.size(); i++) {
			for(int j=0; j< occupiedSeats.size();j++) {
		
				if(allSeatsForTheShowtime.get(i).get(0).equals(occupiedSeats.get(j).get(0)) ) {
					allSeatsForTheShowtime.remove(allSeatsForTheShowtime.get(i));
				}
			}	
		}
		
		return allSeatsForTheShowtime;
	}

	public String getVerification(String seatRow, String seatColumn, String email, String showtimeID) {

		ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatRow=\""
				+ seatRow + "\" AND SeatColumn =\"" + seatColumn + "\" AND ShowtimeID =\"" + showtimeID + "\"");
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
