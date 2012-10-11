package clueGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
	ArrayList<BoardCell> cells;
	Map<Character, String> rooms;
	int numRows;
	int numColumns;

	public Board() {
		cells = new ArrayList<BoardCell>();
		rooms = new HashMap<Character, String>();
	}

	public void loadConfigFiles() {
		// A useful function to use to import the game board is
		// String.split(',');

	}

	public int calcIndex(int rowNum, int columnNum) {
		// A useful function to use to import the game board is
		// String.split(',');
		return -400;// this SHOULD cause tests to fail.
	}

	public void GetRoomCellAt() {
		// A useful function to use to import the game board is
		// String.split(',');

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
}
