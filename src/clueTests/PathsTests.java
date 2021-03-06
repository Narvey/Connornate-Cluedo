package clueTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;

public class PathsTests {

	private static Board board;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		board = new Board();
		board.loadConfigFiles("legend.csv", "board.csv");
	}

	// ******************
	// edges and corners

	@Test
	public void testAdjacency0_0() { // test top left corner
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(0, 0));
		assertEquals(0, testList.size());
	}

	@Test
	public void testAdjacency0_13() { // test top edge
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(0, 13));
		assertTrue(testList.contains(board.calcIndex(0, 12)));
		assertTrue(testList.contains(board.calcIndex(0, 14)));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency12_0() { // test left edge
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(12, 0));
		assertTrue(testList.contains(board.calcIndex(11, 0)));
		assertTrue(testList.contains(board.calcIndex(12, 1)));
		assertTrue(testList.contains(board.calcIndex(13, 0)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacency10_25() { // test right edge
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(10, 25));
		assertTrue(testList.contains(board.calcIndex(10, 24)));
		assertTrue(testList.contains(board.calcIndex(9, 25)));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency25_13() { // test bottom edge
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(25, 11));
		assertEquals(0, testList.size());
	}

	@Test
	public void testAdjacency25_25() { // test bottom right corner
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(25, 25));
		assertEquals(0, testList.size());
	}

	// *************************
	// surrounded by room cells
	@Test
	public void testAdjacency3_9() { // test cell in middle of foundry
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(3, 9));
		assertEquals(0, testList.size());
	}

	@Test
	public void testAdjacency1_22() { // test cell in middle of cellar
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(1, 22));
		assertEquals(0, testList.size());
	}

	// ****************************
	// surrounded by walkway cells
	@Test
	public void testAdjacency5_22() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(5, 22));
		assertTrue(testList.contains(board.calcIndex(5, 23)));
		assertTrue(testList.contains(board.calcIndex(5, 21)));
		assertTrue(testList.contains(board.calcIndex(4, 22)));
		assertTrue(testList.contains(board.calcIndex(6, 22)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacency18_17() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(18, 17));
		assertTrue(testList.contains(board.calcIndex(18, 16)));
		assertTrue(testList.contains(board.calcIndex(18, 18)));
		assertTrue(testList.contains(board.calcIndex(17, 17)));
		assertTrue(testList.contains(board.calcIndex(19, 17)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacency8_17() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(8, 16));
		assertTrue(testList.contains(board.calcIndex(9, 16)));
		assertTrue(testList.contains(board.calcIndex(7, 16)));
		assertTrue(testList.contains(board.calcIndex(8, 17)));
		assertTrue(testList.contains(board.calcIndex(8, 15)));
		assertEquals(4, testList.size());
	}

	// ************
	// by doorways
	@Test
	public void testAdjacency14_20() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(14, 20));
		assertTrue(testList.contains(board.calcIndex(14, 19)));
		assertTrue(testList.contains(board.calcIndex(14, 21)));
		assertTrue(testList.contains(board.calcIndex(13, 20)));
		assertTrue(testList.contains(board.calcIndex(15, 20)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacency17_22() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(17, 22));
		assertTrue(testList.contains(board.calcIndex(17, 21)));
		assertTrue(testList.contains(board.calcIndex(17, 23)));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency5_0() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(5, 0));
		assertTrue(testList.contains(board.calcIndex(5, 1)));
		assertTrue(testList.contains(board.calcIndex(4, 0)));
		assertEquals(2, testList.size());
	}
	
	@Test
	public void testAdjacency15_16() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(15, 16));
		assertTrue(testList.contains(board.calcIndex(15, 17)));
		assertTrue(testList.contains(board.calcIndex(15, 15)));
		assertTrue(testList.contains(board.calcIndex(14, 16)));
		assertTrue(testList.contains(board.calcIndex(16, 16)));
		assertEquals(4, testList.size());
	}

	// **************************
	// by rooms but not doorways
	@Test
	public void testAdjacency6_9() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(6, 9));
		assertTrue(testList.contains(board.calcIndex(6, 8)));
		assertTrue(testList.contains(board.calcIndex(6, 10)));
		assertTrue(testList.contains(board.calcIndex(5, 9)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacency12_9() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(12, 9));
		assertTrue(testList.contains(board.calcIndex(12, 8)));
		assertTrue(testList.contains(board.calcIndex(13, 9)));
		assertTrue(testList.contains(board.calcIndex(11, 9)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacency20_16() {
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(20, 16));
		assertTrue(testList.contains(board.calcIndex(20, 17)));
		assertTrue(testList.contains(board.calcIndex(21, 16)));
		assertTrue(testList.contains(board.calcIndex(19, 16)));
		assertEquals(3, testList.size());
	}

	// ***********************
	// Targets along walkways

	@Test
	public void testTargets2_15() {
		board.calcTargets(board.calcIndex(2, 15), 3);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(0, 14))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(2, 14))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(4, 14))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(1, 15))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(3, 15))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(5, 15))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(0, 16))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(2, 16))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(4, 16))));
		assertEquals(9, targets.size());
	}

	@Test
	public void testTargets6_19() {
		board.calcTargets(board.calcIndex(6, 19), 4);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(6, 15))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(6, 17))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(6, 21))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(6, 23))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(4, 17))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(4, 19))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(4, 21))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(5, 16))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(5, 18))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(5, 20))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(5, 22))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(7, 16))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(7, 18))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(7, 20))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(7, 22))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 17))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 19))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 21))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 18))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 20))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(10, 19))));
		assertEquals(21, targets.size());
	}

	@Test
	public void testTargets17_25() {
		board.calcTargets(board.calcIndex(17, 25), 1);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(18, 25))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(17, 24))));
		assertEquals(2, targets.size());
	}

	@Test
	public void testTargets8_7() {
		board.calcTargets(board.calcIndex(8, 7), 3);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 7))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 8))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 10))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 9))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(10, 8))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(11, 7))));
		assertEquals(6, targets.size());
	}

	// ***********************
	// Targets entering room
	@Test
	public void testTargets15_17() {
		board.calcTargets(board.calcIndex(15, 17), 2);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(14, 16))));
		assertEquals(7, targets.size());
	}

	@Test
	public void testTargets10_23() {
		board.calcTargets(board.calcIndex(10, 23), 3);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 24))));
		assertEquals(9, targets.size());
	}

	@Test
	public void testTargets15_9() {
		board.calcTargets(board.calcIndex(15, 9), 1);
		Set<BoardCell> targets = board.getTargets();
		assertFalse(targets.contains(board.getCellAt(board.calcIndex(15, 8))));
		//can't reach with a roll of 1 (door points down)
		assertEquals(3, targets.size());
		board.calcTargets(board.calcIndex(15, 9), 3);
		targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(15, 8))));
		//can reach with a roll of 3.
		assertEquals(9, targets.size());
	}

	// ***********************
	// Targets leaving room
	@Test
	public void testTargets22_13() {
		board.calcTargets(board.calcIndex(22, 13), 2);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(23, 12))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(23, 14))));
		assertEquals(2, targets.size());
	}

	@Test
	public void testTargets7_13() {
		board.calcTargets(board.calcIndex(7, 13), 1);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(7, 14))));
		assertEquals(1, targets.size());
	}
}
