package Controller;

import View.SeatView;
import Model.SeatModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The class is the controller of seat
 *
 */
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

	/**
	 * The class is used for displaying the seats graphically on board
	 *
	 */
	public class Board {
		private String theBoard[][];

		public Board() {
			theBoard = new String[5][];
			for (int i = 0; i < 5; i++) {
				theBoard[i] = new String[4];
				for (int j = 0; j < 4; j++)
					theBoard[i][j] = "  ";
			}
		}

		String displayColumnHeaders() {
			StringBuilder columnHeaders = new StringBuilder();
			columnHeaders.append("               ");
			for (int j = 1; j < 5; j++)
				columnHeaders.append("   col " + j + "  ");
			columnHeaders.append("\n");
			return columnHeaders.toString();
		}

		/**
		 * This method is used to add hyphens on the board
		 */
		String addHyphens() {
			StringBuilder hyphens = new StringBuilder();
			hyphens.append("               ");
			for (int j = 0; j < 4; j++)
				hyphens.append("+--------");
			hyphens.append("+\n");

			return hyphens.toString();
		}

		/**
		 * This method is used to add space in the squares
		 */
		String addSpaces() {
			StringBuilder spaces = new StringBuilder();
			spaces.append("               ");
			for (int j = 0; j < 4; j++)
				spaces.append("|            ");
			spaces.append("|\n");

			return spaces.toString();
		}

		public String display() {
			StringBuilder display = new StringBuilder();
			display.append(displayColumnHeaders());
			display.append(addHyphens());
			for (int row = 0; row < 5; row++) {
				display.append(addSpaces());
				int real_row = row + 1;
				display.append("    row " + real_row + " ");
				for (int col = 0; col < 4; col++)
					display.append("|      " + addSeatMark(row, col) + "    ");
				display.append("|\n");
				display.append(addSpaces());
				display.append(addHyphens());
			}
			return display.toString();
		}

		/**
		 * This method is used to add marks of seats
		 */
		private String addSeatMark(int row, int col) {
			ArrayList<ArrayList<String>> a = seatModel.returnSeats(showtimeID);

			for (int i = 0; i < a.size(); i++) {
				int real_row = row + 1;
				int real_col = col + 1;
				if (Integer.toString(real_row).equals(a.get(i).get(1))
						&& Integer.toString(real_col).equals(a.get(i).get(2))) {
					theBoard[row][col] = "A";
				}

			}
			return theBoard[row][col];

		}
	}

	/**
	 * The class handlers the actions of searchSeats button
	 *
	 */
	class SearchSeatsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<ArrayList<String>> availableSeats;
			try {
				availableSeats = seatModel.returnSeats(showtimeID);

				Board theboard = new Board();
				seatView.setAvailableSeatsDisplay(theboard.display());
			} catch (NullPointerException ex) {
				seatView.setAvailableSeatsDisplay("Error!");
			}
		}
	}

	/**
	 * The class handlers the actions of searchSeat button
	 *
	 */
	
	class SelectSeatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				String seatRow = seatView.getSeatRow();
				String seatColumn = seatView.getSeatColumn();
				String email = seatView.getEmailInput();

				if (!email.isEmpty()) {
					seatID = seatModel.getSeatId(seatRow, seatColumn, email, showtimeID);

					seatView.displayMessage("Email sent. Seat: Row " + seatRow + " - " + "Column " + seatColumn
							+ " was successfully selected");
					ticketController = new TicketController();

					ticketController.getView().setVisible(true);
					seatView.setVisible(false);
				} else {
					seatView.displayMessage("You must enter email and choose an available seat.");
				}

			} catch (NullPointerException ex2) {
				seatView.displayMessage("You must choose an available seat.");
			}
		}
	}

}