package Model;

import JDBC.SqlDatabaseConnection;

public class TicketModel {
	
	SqlDatabaseConnection myConnection;
	String email;
	SeatModel seat;
	
	public TicketModel(String username) throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}
	
	public void getTicket(String email) {
		
	}
	
	public void retrieveTicket(SeatModel seat) {
		
	}
	
	public void addTicket() {
		
	}
	
	public void cancelTicket() {
		
	}
}
