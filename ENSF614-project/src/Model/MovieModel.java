package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.SqlDatabaseConnection;

public class MovieModel {
	
	SqlDatabaseConnection myConnection;
	private String movieName;
	String showtime;
	

	 public MovieModel() throws ClassNotFoundException {
	    	myConnection = new SqlDatabaseConnection();
	    }


	public ArrayList<String> getMovieVerification(String movieName) {
//		System.out.println(myConnection.doRetrievalQuery("SELECT Name FROM MOVIES WHERE Name= \""+movieName+"\""));
		ArrayList<ArrayList<String>> movies = myConnection.doRetrievalQuery("SELECT Name FROM MOVIES WHERE Name= \""+movieName+"\""); 
		if(movies.get(0).get(0).equals(movieName)){
//			System.out.println("Login Successful!");
			ArrayList<String> moviesList = new ArrayList();
			moviesList.add(movieName);
			return moviesList;
		}
		else {
			throw new NullPointerException();
		}
	}

	public ArrayList<String> getShowtimeVerification(String showtime_selected) {

		ArrayList<ArrayList<String>> showtimes = myConnection.doRetrievalQuery("SELECT Showtime FROM SHOWTIME WHERE ShowTime=\""+showtime_selected+"\""); 
		if(showtimes.get(0).get(0).equals(showtime_selected)){
//			System.out.println("Login Successful!");
			ArrayList<String> showtimeList = new ArrayList();
			showtimeList.add(showtime_selected);
			return showtimeList;
		}
		else {
			throw new NullPointerException();
		}
	}

	public ArrayList<String> returnShowtimesForMovie() {
		
		    	ArrayList<ArrayList<String>> showtimes = myConnection.doRetrievalQuery("SELECT ShowTime FROM SHOWTIME WHERE ShowTime");
		    	ArrayList<String> showtimesForMovie = new ArrayList();
		    	for(ArrayList<String>s:showtimes) {
		    	showtimesForMovie.addAll(s);
		    	}
		    	return showtimesForMovie;
		
	}

}
