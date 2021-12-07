package Model;

import JDBC.SqlDatabaseConnection;

import java.util.ArrayList;

public class AnnouncementsModel {
    SqlDatabaseConnection myConnection;
    ArrayList<String> announcements = new ArrayList<String>();

    public AnnouncementsModel() throws ClassNotFoundException {
        myConnection = new SqlDatabaseConnection();
    }
    public ArrayList<String> announcements(){

    }
}
