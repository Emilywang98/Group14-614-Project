package Model;

import java.util.ArrayList;
import JDBC.SqlDatabaseConnection;

/**
 * The class is the model of seat
 *
 */
public class SeatModel {

	SqlDatabaseConnection myConnection;
	int seatRow;
	int seatColumn;

	public SeatModel() throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}
	
	/**
	 * The method is used to return all seats for the showtime
	 * @param showtimeID
	 * @return all seats for the showtime
	 */
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
	
	/**
	 * The method is used to get seatId which is selected and verified
	 * @param seatRow
	 * @param seatColumn
	 * @param email
	 * @param showtimeID
	 * @return seatId
	 */
	public String getSeatId(String seatRow, String seatColumn, String email, String showtimeID) {

		ArrayList<ArrayList<String>> seat = myConnection.doRetrievalQuery("SELECT * FROM SEAT WHERE SeatRow=\""
				+ seatRow + "\" AND SeatColumn =\"" + seatColumn + "\" AND ShowtimeID =\"" + showtimeID + "\"");
		if (!seat.isEmpty()) {
			ArrayList<String> ticket = new ArrayList<String>();
			ticket.add(seat.get(0).get(0));
			ticket.add("reserved");
			ticket.add(email);
			myConnection.doInsertQuery("TICKET (SeatID, `Status`, Email)", ticket);
		} else {
			throw new NullPointerException();
		}

		return seat.get(0).get(0);//seat.get(0).get(0) is the seatId

	}
}
