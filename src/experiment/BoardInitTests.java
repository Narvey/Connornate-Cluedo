package experiment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clue.Board;

public class BoardInitTests {
	Board brd;
	@Before
	public void setUp() throws Exception {
		brd = new Board();
	}

	@Test
	public void testLoadConfigFiles() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcIndex() {
		assertEquals(3, brd.calcIndex(1, 4));
		assertEquals(0,brd.calcIndex(1, 1));
		assertEquals(brd.getNumColumns(),brd.calcIndex(2, 1));
	}

	@Test
	public void testGetRoomCellAt() {
		fail("Not yet implemented");
	}

}
