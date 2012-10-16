package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Board {
	ArrayList<BoardCell> cells;
	Map<Character, String> rooms;
	int numRows;
	int numColumns;

	public Board() {
		cells = new ArrayList<BoardCell>();
		rooms = new HashMap<Character, String>();
	}

	public void loadConfigFiles(String legendFile, String boardFile) {
		loadLegend(legendFile);
		loadBoard(boardFile);
	}

	public int calcIndex(int row, int column) {
		return -400;// this SHOULD cause tests to fail.
	}

	public RoomCell getRoomCellAt(int row, int column) {
		return new RoomCell(row, column);
	}

	public BoardCell getCellAt(int cell) {
		return new RoomCell(1, 2);
	}

	public ArrayList<BoardCell> getCells() {
		return cells;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	private void loadLegend(String legendFile) {
		Pattern legendLine = Pattern.compile("[a-z],[a-z ]+", Pattern.CASE_INSENSITIVE);
		
		try {
			FileReader f = new FileReader(legendFile);
			Scanner scan = new Scanner(f);
			while (scan.hasNext(legendLine)) {
				String line = scan.nextLine();
				char abbr = line.charAt(0); // the abbreviation for the room
				String room = line.substring(2); // trim off the abbreviation and comma to get the full name
				rooms.put(abbr, room);
			}
		} catch (FileNotFoundException e) {
			System.out.println("I'm sorry, but the " + legendFile
					+ " file is a figment of your imagination.");
			System.out.println(e.getMessage());
		}
	}

	private void loadBoard(String boardFile) {
		// String line = new String();
		String[] spaces;
		try {
			FileReader f = new FileReader(boardFile);
			Scanner scan = new Scanner(f);
			while (scan.hasNextLine()) {
				numRows++;
				spaces = scan.nextLine().split(",");
				numColumns = spaces.length;
				for (int i = 0; i < numColumns; i++) {
					// TODO add better logic
					cells.add(new RoomCell(i, numRows));
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("I'm sorry, but the " + boardFile
					+ " file is a figment of your imagination.");
		}

	}
}
