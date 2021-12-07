package View;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Announcements extends JFrame {
    private JTextArea announcementArea;


    public Announcements(){
        displayGUI();
    }

    public void displayGUI(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(400, 400);

        panel.setLayout(null);

        announcementArea = new JTextArea();
        panel.add(announcementArea);

        frame.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
