package View;

import javax.swing.*;

import Controller.LoginController;
import Controller.MovieController;
import Controller.TheatreController;
import Model.LoginModel;
import Model.TheatreModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheatreView extends JFrame{

    private JButton theatre1;
    private JButton theatre2;
    private JButton theatre3;
    
//    public void runApp(){
//
//    	theatre1.addActionListener(this);
//    	theatre2.addActionListener(this);
//    	theatre3.addActionListener(this);
//
//        
//    }
    private MovieSearchView movieSearch;

    public TheatreView(){
        this.setTitle("Theatre view Page");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 250);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title = new JLabel ("Please choose one of the following theatre");
        title.setBounds(50, 50, 500, 50);
        title.setFont(new Font("Courier New", Font.BOLD, 18));
        this.add(title);

        theatre1 = new JButton("Ciniplex Chinook");
        theatre1.setBounds(150, 100, 250, 25);
        this.add(theatre1);

        theatre2 = new JButton("Ciniplex Crowfoot");
        theatre2.setBounds(150, 150, 250, 25);
        this.add(theatre2);

        theatre3 = new JButton("Ciniplex Sunridge");
        theatre3.setBounds(150, 200, 250, 25);
        this.add(theatre3);

        this.setVisible(true);
    }

    public void displayMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public void addTheatreListener1(ActionListener listenForTheatre){
        theatre1.addActionListener(listenForTheatre);
    }
    
    public void addTheatreListener2(ActionListener listenForTheatre){
        theatre2.addActionListener(listenForTheatre);
    }
    
    public void addTheatreListener3(ActionListener listenForTheatre){
        theatre3.addActionListener(listenForTheatre);
    }

//    public static void main(String[] args) {
//       TheatreView theatreView = new TheatreView();
//       TheatreModel model = new TheatreModel();
//		TheatreController controller = new TheatreController(theatreView, model);
//		theatreView.runApp();
//    }

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == theatre1 || e.getSource() == theatre2 ||  e.getSource() == theatre3) {
			
//			movieSearch = new MovieSearchView();
//			MovieController movieController = new MovieController();
//		}
//		
//	}


}
