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
//	    private MovieModel movie;
	    

	    
	    public ArrayList<ArrayList<String>> returnSeats(){
//	    	System.out.println(myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT"));
	    	ArrayList<ArrayList<String>> seatMatrix = myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT");
//	    	System.out.println("Login Successful!");
//	    	ArrayList<String> availableSeats = new ArrayList();
//	    	for(ArrayList<String>s:seatMatrix) {
//	    		availableSeats.addAll(s);
//		    	}
	    	
	    	return seatMatrix;
	    }

	
		 public ArrayList<String> getVerification(int seatRow, int seatColumn) {

				//query the seatrow and seatcolumn
//				System.out.println(myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT WHERE SeatRow=\""+seatRow+"\" AND SeatColumn =\""+seatColumn+"\""));
		    	ArrayList<ArrayList<String>> matrix = myConnection.doRetrievalQuery("SELECT SeatRow, SeatColumn FROM SEAT WHERE SeatRow=\""+seatRow+"\" AND SeatColumn =\""+seatColumn+"\"");
				if(matrix.get(0).get(0).equals(Integer.toString(seatRow)) && matrix.get(0).get(1).equals(Integer.toString(seatColumn))){
					ArrayList<String> seats = new ArrayList();
					seats.add(Integer.toString(seatRow));
					seats.add(Integer.toString(seatColumn));
					return seats;
				}
				else{
					throw new NullPointerException();
				}

		    }
		}
