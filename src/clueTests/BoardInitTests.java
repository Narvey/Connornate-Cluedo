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
		
		room = board.getRoomCellAt(4, 0);
		assertTrue(room.isDoorway());
		assertEquals(RoomCell.DoorDirection.DOWN, room.getDoorDirection());
	}
}
