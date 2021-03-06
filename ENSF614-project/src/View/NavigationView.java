package View;

import Controller.TheatreController;
import Controller.TicketController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Navigation view provides a navigation page for cancel button and book ticket
 */
public class NavigationView extends JFrame implements ActionListener {
    private JButton cancelButton = new JButton("Cancel Ticket");
    private JButton bookTicketButton = new JButton("Book Ticket");
    private TicketController ticketController;
    private TheatreController theatreController;
    private JFrame frame;

    public NavigationView(){
        cancelButton.addActionListener(this);
        bookTicketButton.addActionListener(this);
    }

    public void displayGUI(){
        setTitle("Navigation Portal");
        JPanel panel = new JPanel();
        frame = new JFrame();

        //configure the frame
        frame.setSize(350, 200);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        bookTicketButton.setBounds(80, 50, 150, 25);
        panel.add(bookTicketButton);

        cancelButton.setBounds(80, 100, 150, 25);
        panel.add(cancelButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //cancel button pressed
        if(e.getSource() == cancelButton){
            ticketController = new TicketController();
            frame.setVisible(false);
        }

        //book ticket pressed
        if(e.getSource() == bookTicketButton){
            theatreController = new TheatreController();
            frame.setVisible(false);
        }
    }
}
