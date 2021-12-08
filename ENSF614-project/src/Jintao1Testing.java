import java.io.BufferedReader;
import java.util.ArrayList;

public class Jintao1Testing{
	private char theBoard[][];
	
	public Jintao1Testing() {
		theBoard = new char[5][];
		for (int i = 0; i < 5; i++) {
			theBoard[i] = new char[4];
			for (int j = 0; j < 4; j++)
				theBoard[i][j] = ' ';
		}
	}
	String displayColumnHeaders() {
		StringBuilder columnHeaders= new StringBuilder();    
		columnHeaders.append("          ");
		for (int j = 1; j < 5; j++)
			columnHeaders.append("  col " + j + " ");
		columnHeaders.append("\n");
		return columnHeaders.toString();
	}
	
	/**
	 * This method is used to add hyphens on the board
	 */
	String addHyphens() {
		StringBuilder hyphens= new StringBuilder();
		hyphens.append("          ");
		for (int j = 0; j < 4; j++)
			hyphens.append("+-------");
		hyphens.append("+\n");
		
		return hyphens.toString();
	}
	
	/**
	 * This method is used to add space in the squares
	 */
	String addSpaces() {
		StringBuilder spaces= new StringBuilder();
		spaces.append("          ");
		for (int j = 0; j < 4; j++)
			spaces.append("|       ");
		spaces.append("|\n");
		
		return spaces.toString();
	}
	
	public String display() {
		StringBuilder display= new StringBuilder(); 
		display.append(displayColumnHeaders());
		display.append(addHyphens());
		for (int row = 0; row < 5; row++) {
			display.append(addSpaces());
			int real_row = row+1;
			display.append("    row " + real_row + ' ');
			for (int col = 0; col < 4; col++)
				display.append("|   " + addSeatMark(row, col) + "   ");
			display.append("|\n");
			display.append(addSpaces());
			display.append(addHyphens());
		}
		return display.toString();
	}
	
	private char addSeatMark(int row, int col) {
		ArrayList<ArrayList<String>> a = new ArrayList<>();

	    ArrayList<String> a1 = new ArrayList<String>();
	    ArrayList<String> a2 = new ArrayList<String>();
	    ArrayList<String> a3 = new ArrayList<String>();

	    a1.add("1");//ticketid
	    a1.add("2");//seat row
	    a1.add("2");//seat col

	    a2.add("2");
	    a2.add("3");
	    a2.add("3");

	    a3.add("3");
	    a3.add("4");
	    a3.add("4");
	    
	    a.add(a1);
	    a.add(a2);
	    a.add(a3);

		for (int i=0; i< a.size(); i++) {
			int real_row = row+1;
			int real_col = col+1;
			if(Integer.toString(real_row).equals(a.get(i).get(1))&& Integer.toString(real_col).equals(a.get(i).get(2))) {
				theBoard[row][col] = 'A';
			}
			
		}
		return theBoard[row][col];
		
	}
	
	
	public static void main(String[] args) {
		Jintao1Testing theboard = new Jintao1Testing();
		System.out.println(theboard.display());
	}
	
	
}
