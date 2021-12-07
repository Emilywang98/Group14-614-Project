package Controller;

import View.MovieSearchView;
import View.SeatView;
import Model.SeatModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController {
	private SeatView seatView;
	private SeatModel seatModel;
	String seatID;
	String showtimeID;
	private TicketController ticketController;

	public SeatController(String showtimeId) {
		this.showtimeID = showtimeId;
		seatView = new SeatView();
		try {
			seatModel = new SeatModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		seatView.setVisible(true);
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
				availableSeats = seatModel.returnSeats(showtimeID);
				StringBuffer sb = new StringBuffer();

				for (int i = 0; i < availableSeats.size(); i++) {
					for (int j = 1; j < availableSeats.get(i).size(); j++) {
						sb.append("" + availableSeats.get(i).get(j) + "          ");
					}
					sb.append("\n");
				}
				String availableSeatsString = sb.toString();
//				String output = "Avaiable seats: o       Occupied seats: x  \n";
				seatView.setAvailableSeatsDisplay("Row   " + " Column\n" + availableSeatsString);
//				seatView.setAvailableSeatsDisplay(output);
			} catch (NullPointerException ex) {
				seatView.setAvailableSeatsDisplay("Error!");
			}
		}
	}

	class SelectSeatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				String seatRow = seatView.getSeatRow();
				String seatColumn = seatView.getSeatColumn();
				String email = seatView.getEmailInput();

				if (!email.isEmpty()) {
					seatID = seatModel.getVerification(seatRow, seatColumn, email, showtimeID);

//					seatView.setTheDisplay("");
					seatView.displayMessage("Email sent. Seat: \" + seatRow + \" - \" + seatColumn + \" was successfully selected");
					ticketController = new TicketController();

					ticketController.getView().setVisible(true);
					seatView.setVisible(false);
				} else {
					seatView.displayMessage("You must enter email and choose an available seat.");
				}

//			} catch (NumberFormatException ex1) {
//				seatView.setTheDisplay("Error!");
			} catch (NullPointerException ex2) {
				seatView.displayMessage("You must choose an available seat.");
			}
		}
	}

}