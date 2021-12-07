package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Announcements extends JFrame {
    private ArrayList<String> announcements;
    private JLabel title;

    public void setAnnouncements(ArrayList<String> announcements){
        this.announcements = announcements;
        displayGUI();
    }
    public void displayGUI(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(700, 400);

        panel.setLayout(null);

        title = new JLabel("ANNOUNCEMENTS");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        frame.add(title);

        int j = 50;
        for(int i = 0; i<announcements.size(); i++){
            j+=30;
            JLabel label = new JLabel(announcements.get(i));
            label.setBounds(10, j, 650, 25);
            frame.add(label);
        }

        JLabel label = new JLabel("");
        label.setBounds(10, j+30, 650, 25);
        frame.add(label);

        frame.setVisible(true);
    }
}
