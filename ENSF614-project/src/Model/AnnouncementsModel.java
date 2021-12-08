package Model;

import JDBC.SqlDatabaseConnection;

import java.util.ArrayList;

/**
 * Announcement model that retrieves the announcements from the database
 */
public class AnnouncementsModel {
    SqlDatabaseConnection myConnection;
    ArrayList<ArrayList<String>> getQuery;
    ArrayList<String> announcements;

    public AnnouncementsModel() throws ClassNotFoundException {
        myConnection = new SqlDatabaseConnection();
        announcements = new ArrayList<String>();
    }

    public ArrayList<String> getAnnouncements(){
        String query = "SELECT * FROM ANNOUNCEMENTS";

        getQuery = myConnection.doRetrievalQuery(query);

        for (int i = 0; i < getQuery.size(); i++) {
            String message = getQuery.get(i).get(1);
            announcements.add(message);
        }

        return announcements;
    }
}
