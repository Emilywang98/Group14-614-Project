package Controller;

import View.SeatView;
import Model.SeatModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController {
	SeatView seatView;
	SeatModel seatModel;
	ArrayList<String> seatInfo;

	public SeatController(SeatView seatView, SeatModel seatModel) {
		this.seatView = new SeatView();
		this.seatModel = seatModel;
		seatView.addSelectSeatActionListener(new SelectSeatListener());
//		seatView.addSearchSeatsActionListener(new SearchSeatsListener());
	}

	public SeatView getView() {
		return seatView;
	}

//	class SearchSeatsListener implements ActionListener {

//		@Override
//		public void actionPerformed(ActionEvent e) {
//			ArrayList<String> availableSeats;
//			try {
//				availableSeats=seatModel.returnSeats();
//				StringBuffer sb = new StringBuffer();
//			      
//			      for (String s : availableSeats) {
//			         sb.append(s);
//			         sb.append("\n");
//			      }
//			      String availableSeatsString = sb.toString();
//				
//				seatView.setAvailableSeatsDisplay(availableSeatsString);
//			}catch(NumberFormatException ex) {
//				seatView.setAvailableSeatsDisplay("Error!");
//			}
//		}
//	}

	class SelectSeatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int seatRow = seatView.getSeatRow();
				int seatColumn = seatView.getSeatColumn();
				// still need to check if seatnumber is valid/ in database

				seatInfo = seatModel.getVerification(seatRow, seatColumn);

				seatView.setTheDisplay("Seat was successfully selected");

			} catch (NumberFormatException ex1) {
				seatView.setTheDisplay("Error!");
			} catch (NullPointerException ex2) {
				seatView.setTheDisplay("Error!");
			}
		}
	}

	public ArrayList<String> getSeatInfo() {
		return seatInfo;
	}
}