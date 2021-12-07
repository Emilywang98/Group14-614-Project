package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationView extends JFrame implements ActionListener {
    private JButton cancelButton = new JButton("Cancel Ticket");
    private JButton bookTicketButton = new JButton("Book Ticket");
    PaymentView payment;
    TheatreView theatreView;

    public void displayGUI(){
        setTitle("Navigation Portal");
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

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
            payment = new PaymentView();
            payment.setVisible(true);
        }

        //book ticket pressed
        if(e.getSource() == bookTicketButton){
            theatreView = new TheatreView();
            theatreView.setVisible(true);
        }
    }
}
