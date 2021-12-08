package Controller;

import Model.AnnouncementsModel;
import View.Announcements;

import java.util.ArrayList;

/**
 * Connects the announcements view with controller
 */
public class AnnouncementsController {
    private Announcements view;
    private AnnouncementsModel model;
    private ArrayList<String> announcementsList;


    public AnnouncementsController(){
        try {
            this.model = new AnnouncementsModel();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        announcementsList = model.getAnnouncements();
        this.view = new Announcements();
        view.setAnnouncements(announcementsList);
    }
}
