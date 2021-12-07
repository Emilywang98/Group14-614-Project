package Controller;

import View.MovieSearchView;
import View.SeatView;
import Model.SeatModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController {
	private MovieSearchView movieSearchView;
	private MovieController movieController;
	private SeatView seatView;
	private SeatModel seatModel;
	private SeatController thisSeatController;
	String seatID;
	String showID;
	private TicketController ticketController;

	public SeatController(String showId) {
		this.showID = showId;
		seatView = new SeatView();
		try {
			seatModel = new SeatModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		thisSeatController = this;

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
//			System.out.println(movieSearchView.getShowtime());
			try {
				availableSeats = seatModel.returnSeats();
//				System.out.println("fasfdafd");
				StringBuffer sb = new StringBuffer();

				for (int i = 0; i < availableSeats.size(); i++) {
					for (int j = 0; j < availableSeats.get(i).size(); j++) {
						sb.append("" + availableSeats.get(i).get(j) + "          ");
					}
					sb.append("\n");
				}
				String availableSeatsString = sb.toString();

				seatView.setAvailableSeatsDisplay("Row   " + " Column\n" + availableSeatsString);
			} catch (NullPointerException ex) {
//				System.out.println("fsafdfas");
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
					seatID = seatModel.getVerification(seatRow, seatColumn, email);

					seatView.setTheDisplay("Seat: " + seatRow + " - " + seatColumn + " was successfully selected");
					seatView.displayMessage("Email sent.");
					ticketController = new TicketController();

					ticketController.getView().setVisible(true);
					seatView.setVisible(false);
				} else {
					seatView.setTheDisplay("You must enter email and choose an available seat.");
				}

			} catch (NumberFormatException ex1) {
				seatView.setTheDisplay("Error!");
			} catch (NullPointerException ex2) {
				seatView.setTheDisplay("You must choose an available seat.");
			}
		}
	}

}