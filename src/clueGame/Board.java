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
		loadLegend();
		loadBoard();
	}

	public int calcIndex(int row, int column) {
		// A useful function to use to import the game board is
		// String.split(',');
		return -400;// this SHOULD cause tests to fail.
	}

	public RoomCell getRoomCellAt(int row, int column) {
		// A useful function to use to import the game board is
		// String.split(',');
		return new RoomCell();
	}
	
	public BoardCell getCellAt(int cell) {
		return new RoomCell();
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
	
	private void loadLegend() {
		
	}
	
	private void loadBoard() {
		
	}
}
