package Controller;
import View.SeatView;
import Model.SeatModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController {
	SeatView seatView;
	SeatModel seatModel;
	
	
	public SeatController(SeatView seatView, SeatModel seatModel) {
		this.seatView = new SeatView();
		this.seatModel = seatModel;
		seatView.addSelectSeatActionListener(new SelectSeatListener());
		seatView.addSearchSeatsActionListener(new SearchSeatsListener());
	}
	
	public SeatView getView() {
		return seatView;
	}

	class SearchSeatsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> availableSeats;
			try {
				availableSeats=seatModel.returnSeats();
				StringBuffer sb = new StringBuffer();
			      
			      for (String s : availableSeats) {
			         sb.append(s);
			         sb.append("\n");
			      }
			      String availableSeatsString = sb.toString();
				
				seatView.setAvailableSeatsDisplay(availableSeatsString);
			}catch(NumberFormatException ex) {
				seatView.setAvailableSeatsDisplay("Error!");
			}
		}
	}


	class SelectSeatListener implements ActionListener {
		
        @Override
        public void actionPerformed(ActionEvent e) {
        	int seatNum;
        	try {
        		seatNum=seatView.getSeatNumber();
        		//still need to check if seatnumber is valid/ in database
        		seatView.setTheDisplay("Seat " + seatNum + " was successfully selected");
        		
        	}catch(NumberFormatException ex) {
				seatView.setTheDisplay("Error!");
			}
        }
    }
}