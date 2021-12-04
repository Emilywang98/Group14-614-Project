package Controller;
import View.SeatView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatController {
	SeatView seatView;
	
	
	public SeatController(MovieController thisMovieController) {
		this.seatView = new SeatView();
		
		seatView.addSelectSeatActionListener(new SelectSeatListener());
		seatView.addSearchSeatsActionListener(new SearchSeatsListener());
	}
	
	public SeatView getView() {
		return seatView;
	}

	class SearchSeatsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String availableSeats;
			try {
				availableSeats=seatView.getAvailableSeats();
				seatView.setAvailableSeatsDisplay(availableSeats);

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