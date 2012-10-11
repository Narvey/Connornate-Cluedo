package experiment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clueGame.Board;

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
		assertEquals(3, brd.calcIndex(0, 3));
		assertEquals(0,brd.calcIndex(0, 0));
		assertEquals(brd.getNumColumns()*brd.getNumRows()-1, brd.calcIndex(brd.getNumRows()-1,brd.getNumColumns()-1));
		assertEquals(brd.getNumColumns(),brd.calcIndex(1, 0));
	}

	@Test
	public void testGetRoomCellAt() {
		fail("Not yet implemented");
	}

}
