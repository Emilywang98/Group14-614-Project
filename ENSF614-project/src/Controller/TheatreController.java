package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TheatreView;


public class TheatreController {
	
	TheatreView view;

	public TheatreController(){
	    view = new TheatreView();
	    view.addTheatreListener1(new TheatreListener1());
	    view.addTheatreListener2(new TheatreListener2());
	    view.addTheatreListener3(new TheatreListener3());
	}
	
	class TheatreListener1 implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	MovieController movieController = new MovieController();
	    	movieController.getView().setVisible(true);
	    	view.setVisible(false);
	    }
	
	}
	class TheatreListener2 implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	MovieController movieController = new MovieController();
	    	movieController.getView().setVisible(true);
	    	view.setVisible(false);
	    }
	
	}
	class TheatreListener3 implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	MovieController movieController = new MovieController();
	    	movieController.getView().setVisible(true);
	    	view.setVisible(false);
	    }
	
	}


}
