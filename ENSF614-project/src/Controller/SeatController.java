package Controller;

import View.SeatView;
import Model.SeatModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController {
	SeatView seatView;
	SeatModel seatModel;
	MovieController movieController;
	String seatID;
	TicketController ticketController;

	public SeatController(SeatView seatView, SeatModel seatModel) {
		this.seatView = seatView;
		this.seatModel = seatModel;
//		this.movieController = movieController;
		seatView.addSelectSeatActionListener(new SelectSeatListener());
		seatView.addSearchSeatsActionListener(new SearchSeatsListener());
	}

	public SeatView getView() {
		return seatView;
	}

	class SearchSeatsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<ArrayList<String>> availableSeats;
			try {
				availableSeats=seatModel.returnSeats();
				StringBuffer sb = new StringBuffer();
			      
				for(int i = 0; i < availableSeats.size(); i++) {
			        for(int j = 0; j < availableSeats.get(i).size(); j++){
			            sb.append("" + availableSeats.get(i).get(j) + "          ");
			        }
			        sb.append("\n" );
			    }
//			      for (String s : availableSeats) {
//			         sb.append(s);
//			         sb.append("\n");
//			      }
			      String availableSeatsString = sb.toString();
				
				seatView.setAvailableSeatsDisplay("Row   " + " Column\n" + availableSeatsString);
			}catch(NullPointerException ex) {
				seatView.setAvailableSeatsDisplay("Error!");
			}
		}
	}

	class SelectSeatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int seatRow = seatView.getSeatRow();
				int seatColumn = seatView.getSeatColumn();
				String email = seatView.getEmailInput();

				seatID = seatModel.getVerification(seatRow, seatColumn, email);

				seatView.setTheDisplay("Seat: " + seatRow + " - " + seatColumn + " was successfully selected");
				
				ticketController = new TicketController();
				
				ticketController.getView().setVisible(true);
				seatView.setVisible(false);

			} catch (NumberFormatException ex1) {
				seatView.setTheDisplay("Error!");
			} catch (NullPointerException ex2) {
				seatView.setTheDisplay("Error!");
			}
		}
	}

	
}