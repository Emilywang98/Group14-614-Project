package Controller;
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
//	        try {
//	        } // Login was not successful
//	        catch (NumberFormatException e1){
//	        	view.displayMessage("ERROR!");
//	        }
//	        catch(NullPointerException e2){
//	        	view.displayMessage("ERROR!");
//	        }
	    }
	
	}
	class TheatreListener2 implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	MovieController movieController = new MovieController();
	    	movieController.getView().setVisible(true);
	    	view.setVisible(false);
//	        try {
//	        } // Login was not successful
//	        catch (NumberFormatException e1){
//	        	view.displayMessage("ERROR!");
//	        }
//	        catch(NullPointerException e2){
//	        	view.displayMessage("ERROR!");
//	        }
	    }
	
	}
	class TheatreListener3 implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	MovieController movieController = new MovieController();
	    	movieController.getView().setVisible(true);
	    	view.setVisible(false);
//	        try {
//	        } // Login was not successful
//	        catch (NumberFormatException e1){
//	        	view.displayMessage("ERROR!");
//	        }
//	        catch(NullPointerException e2){
//	        	view.displayMessage("ERROR!");
//	        }
	    }
	
	}


}
