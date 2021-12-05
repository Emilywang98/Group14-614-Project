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
		
		ArrayList<String > seatInfo;
		ArrayList<String> availableSeats;
		
		public SeatModel() throws ClassNotFoundException {
			myConnection = new SqlDatabaseConnection();
		}
	 	
//	    private boolean ifReserved;
//	    private MovieModel movie;
	    

	    
	    public ArrayList<String> returnSeats(){
//	    	System.out.println("SELECT SeatRow, SeatColumn FROM SEAT");
	    	ArrayList<ArrayList<String>> seatMatrix = myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT");
	    	availableSeats.add("Seat Row: " + Integer.toString(seatRow) +"seat coloum: " + Integer.toString(seatColumn));
	    	
	    	return availableSeats;
	    }

	
		 public ArrayList<String> getVerification(int seatRow, int seatColumn) {

				//query the seatrow and seatcolumn
//				System.out.println("SELECT SeatRow, SeatColumn FROM SEAT WHERE SeatRow=\""+seatRow+"\" AND SeatColumn =\""+seatColumn+"\"");
		    	ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT WHERE SeatRow=\""+seatRow+"\" AND SeatColumn =\""+seatColumn+"\"");

				if(matrix.get(0).get(0).equals(Integer.toString(seatRow)) && matrix.get(0).get(1).equals(Integer.toString(seatColumn))){
					System.out.println("Seat Successful!");
					ArrayList<String> seatInfo = new ArrayList();
					seatInfo.add(Integer.toString(seatRow));
					seatInfo.add(Integer.toString(seatColumn));
					return seatInfo;
				}
				else{
					throw new NullPointerException();
				}

		    }
		}
