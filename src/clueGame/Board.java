package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
	ArrayList<BoardCell> cells;
	Map<Character, String> rooms;
	int numRows;
	int numColumns;
	String LegendFile;
	String BoardFile;
	Scanner scan;

	public Board() {
		cells = new ArrayList<BoardCell>();
		rooms = new HashMap<Character, String>();
		LegendFile="legend.csv";
		BoardFile="board.csv";
		loadConfigFiles();
	}

	public void loadConfigFiles() {
		loadLegend();
		loadBoard();
	}

	public int calcIndex(int row, int column) {
		return -400;// this SHOULD cause tests to fail.
	}

	public RoomCell getRoomCellAt(int row, int column) {
		return new RoomCell(row, column);
	}

	public BoardCell getCellAt(int cell) {
		return new RoomCell(1,2);
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
		char abbr; //the abbreviation for the room
		String room; //the full name of the room
		try{
			FileReader f = new FileReader(LegendFile);
			scan = new Scanner(f);
			while(scan.hasNext(/*"A-Z,[A-Za-z]*"*/)){//TODO Connor, help with regex!!
				room =scan.nextLine();
				abbr = room.charAt(0);
				room = room.substring(2);//trim off the abbreviation and comma.
				rooms.put(abbr, room);
			}
		}catch(FileNotFoundException e){
			System.out.println("I'm sorry, but the "+LegendFile+" file is a figment of your imagination.");
			System.out.println(e.getMessage());
		}
	}

	private void loadBoard() {
		//String line = new String();
		String[] spaces;
		try{
			FileReader f = new FileReader(BoardFile);
			scan = new Scanner(f);
			while(scan.hasNextLine()){
				numRows++;
				spaces=scan.nextLine().split(",");
				numColumns=spaces.length;
				for(int i=0;i<numColumns;i++){
					//TODO add better logic
					cells.add(new RoomCell(i,numRows));
				}

			}
		}catch(FileNotFoundException e){
			System.out.println("I'm sorry, but the "+BoardFile+" file is a figment of your imagination.");
		}

	}
}
