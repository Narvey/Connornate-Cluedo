package clueTests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.RoomCell;

public class BoardInitTests {
	private static Board board;
	
	@BeforeClass
	public static void setup() {
		board = new Board();
	}
	
	@Test
	public void testRooms() {
		Map<Character, String> rooms = board.getRooms();
		assertEquals(9, rooms.size());
		assertEquals("Torture chamber", rooms.get('T'));
		assertEquals("Foundry", rooms.get('F'));
		assertEquals("Dungeon", rooms.get('D'));
		assertEquals("Tower", rooms.get('O'));
		assertEquals("Walkway", rooms.get('W'));
	}
	
	@Test
	public void testBoardSize() {
		assertEquals(26, board.getNumColumns());
		assertEquals(26, board.getNumRows());
	}
	
	@Test
	public void testDoors() {
		RoomCell room = board.getRoomCellAt(4, 0);
		assertTrue(room.isDoorway());
		assertEquals(RoomCell.DoorDirection.DOWN, room.getDoorDirection());
		
		room = board.getRoomCellAt(13, 7);
		assertTrue(room.isDoorway());
		assertEquals(RoomCell.DoorDirection.RIGHT, room.getDoorDirection());
		
		room = board.getRoomCellAt(16, 10);
		assertTrue(room.isDoorway());
		assertEquals(RoomCell.DoorDirection.UP, room.getDoorDirection());
		
		room = board.getRoomCellAt(21, 12);
		assertTrue(room.isDoorway());
		assertEquals(RoomCell.DoorDirection.RIGHT, room.getDoorDirection());
		
		// check a room cell is not a doorway
		room = board.getRoomCellAt(0, 0);
		assertFalse(room.isDoorway());
		
		// check a walkway is not a doorway
		BoardCell cell = board.getCellAt(board.calcIndex(0,5));
		assertFalse(cell.isDoorway());
	}
	
	@Test
	public void testCalcIndex() {
		assertEquals(3, board.calcIndex(0, 3));
		assertEquals(0,board.calcIndex(0, 0));
		assertEquals(board.getNumColumns()*board.getNumRows()-1, board.calcIndex(board.getNumRows()-1,board.getNumColumns()-1));
		assertEquals(board.getNumColumns(),board.calcIndex(1, 0));
	}

}
