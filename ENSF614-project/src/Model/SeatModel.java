package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class SeatModel {
		
	ArrayList<String > seats;
		SqlDatabaseConnection myConnection;
	 	private int seatRow;
	 	private int seatColumn;
	    private boolean ifReserved;
	    private MovieModel movie;
	    
	    public SeatModel() throws ClassNotFoundException {
	    	myConnection = new SqlDatabaseConnection();
	    }
	    
	    public ArrayList<String> returnSeats(){
	    	System.out.println("SELECT SeatRow, SeatColumn FROM SEAT");
	    	ArrayList<ArrayList<String>> seatMatrix = myConnection.doQuery("SELECT SeatRow, SeatColumn FROM SEAT");
	    	seats.add("Seat Row: " + Integer.toString(seatRow) +"seat coloum: " + Integer.toString(seatColumn));
	    	
	    	return seats;
	    }
	    public void selectSeat(int seat){

	    }
	
}
