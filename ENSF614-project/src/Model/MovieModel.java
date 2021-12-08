package Model;

import java.util.ArrayList;
import JDBC.SqlDatabaseConnection;

/**
 * The class is the model of movie
 *
 */
public class MovieModel {

	SqlDatabaseConnection myConnection;
	String showtime;

	public MovieModel() throws ClassNotFoundException {
		myConnection = new SqlDatabaseConnection();
	}
	
	/**
	 * The method is used to verify if movie is found or not
	 * @param movieName
	 * @return movie
	 */
	public ArrayList<String> verifyMovie(String movieName) {
		ArrayList<ArrayList<String>> movies = myConnection
				.doRetrievalQuery("SELECT Name FROM MOVIES WHERE Name= \"" + movieName + "\"");
		if (!movies.isEmpty()) {
			ArrayList<String> movie = new ArrayList();
			movie.add(movieName);
			return movie;
		} else {
			throw new NullPointerException();
		}
	}
	
	/**
	 * The method is used to get showtimeId of verified showtime
	 * @param showtime_selected
	 * @return showtimeIdList
	 */
	public ArrayList<String> getVerifiedShowtimeId(String showtime_selected) {

		ArrayList<ArrayList<String>> showtimeId = myConnection
				.doRetrievalQuery("SELECT ShowTimeID FROM SHOWTIME WHERE ShowTime=\"" + showtime_selected + "\"");
		if (!showtimeId.isEmpty()) {
			ArrayList<String> showtimeIdList = new ArrayList();
			showtimeIdList.add(showtimeId.get(0).get(0));
			return showtimeIdList;
		} else {
			throw new NullPointerException();
		}
	}
	
	/**
	 * The method is used to return all showtimes found for the movie
	 * @param movie_selected
	 * @return showtimesForMovie
	 */
	public ArrayList<String> returnShowtimesForMovie(String movie_selected) {

		ArrayList<ArrayList<String>> showtimes = myConnection
				.doRetrievalQuery("SELECT ShowTime FROM SHOWTIME WHERE MovieName=\"" + movie_selected + "\"");
		ArrayList<String> showtimesForMovie = new ArrayList();
		for (ArrayList<String> s : showtimes) {
			showtimesForMovie.addAll(s);
		}
		return showtimesForMovie;

	}
	

}
