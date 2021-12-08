package Controller;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TheatreView;
import Model.TheatreModel;


public class TheatreController {
	
	TheatreView view;
	TheatreModel model;

	public TheatreController(){
	    view = new TheatreView();
	    model = new TheatreModel();
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
	public TheatreView getView() {
		// TODO Auto-generated method stub
		return view;
	}


}
