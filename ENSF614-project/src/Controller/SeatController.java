package Controller;
import View.SeatView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatController {
	SeatView seatView;
	
	
	public SeatController() {
		this.seatView = new SeatView();
		
		seatView.addSelectSeatActionListener(new SelectSeatListener());
	}
	
	public SeatView getView() {
		return seatView;
	}
	class SelectSeatListener implements ActionListener {
		
        @Override
        public void actionPerformed(ActionEvent e) {
        	int seat;
        	try {
        		seat=seatView.getSeat();
        		seatView.setTheDisplay("Seat was successfully selected");
        		
        	}catch(NumberFormatException ex) {
				seatView.setTheDisplay("Error!");
			}
        }
    }
}