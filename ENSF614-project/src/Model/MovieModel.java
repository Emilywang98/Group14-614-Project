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

//	public MovieModel(String movieName) {
//		this.setMovieName(movieName);
//	}
//
//	private void setMovieName(String movieName) {
//		this.movieName = movieName;
//	}

	private ArrayList<SeatModel> seats;

	public void selectMovie(String movieName) {

	}

	public void displayShowtimes() {

	}

	public void selectShowtime(String showtime) {

	}

}
