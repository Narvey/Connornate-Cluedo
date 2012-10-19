package clueTests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
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
		board.loadConfigFiles("legend.csv","board.csv");
	}
	
	@Test
	public void ThisTestNeedsToPass(){//for scratch work.  not to be graded.
		assertEquals(board.getNumColumns(), board.calcIndex(1, 0)); 
		assertEquals(363, board.calcIndex(13,board.getNumColumns()-1));
		assertEquals(board.calcIndex(25, 25),board.getNumColumns()*board.getNumRows()-1);
	}
	/////////////////////////////////////////
	//edges and corners
	@Test
	public void testAdjacencyA1()//These are named after the cell in the spreadsheet
	{
		LinkedList<Integer> testList = board.getAdjList(0);
		assertTrue(testList.contains(board.getNumColumns()));
		assertTrue(testList.contains(1));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacencyL1()
	{
		LinkedList<Integer> testList = board.getAdjList(11);
		assertTrue(testList.contains(10));
		assertTrue(testList.contains(board.calcIndex(1, 11)));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyA13()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(12, 0));
		assertTrue(testList.contains(board.calcIndex(11, 0)));
		assertTrue(testList.contains(board.calcIndex(12, 1)));
		assertTrue(testList.contains(board.calcIndex(13, 0)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyZ14()
	{
		LinkedList<Integer> testList = board.getAdjList(363);
		assertTrue(testList.contains(362));
		assertTrue(testList.contains(board.calcIndex(12, 26)));
		assertTrue(testList.contains(board.calcIndex(14, 26)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyN26()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(25, 11));
		assertTrue(testList.contains(board.calcIndex(24, 11)));
		assertTrue(testList.contains(board.calcIndex(25, 10)));
		assertTrue(testList.contains(board.calcIndex(25, 12)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyZ26()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(25, 25));
		assertTrue(testList.contains(board.getNumColumns()*board.getNumRows()-2));
		assertTrue(testList.contains(board.calcIndex(24, 25)));
		assertEquals(2, testList.size());
	}
	/////////////////////////////////////////
	//surrounded by room cells
	@Test
	public void testAdjacencyJ4()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(3, 9));
		assertTrue(testList.contains(board.calcIndex(3, 10)));
		assertTrue(testList.contains(board.calcIndex(3, 8)));
		assertTrue(testList.contains(board.calcIndex(2, 9)));
		assertTrue(testList.contains(board.calcIndex(4, 9)));
		assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacencyW2()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(1, 22));
		assertTrue(testList.contains(board.calcIndex(1, 23)));
		assertTrue(testList.contains(board.calcIndex(1, 24)));
		assertTrue(testList.contains(board.calcIndex(2, 22)));
		assertTrue(testList.contains(board.calcIndex(0, 22)));
		assertEquals(4, testList.size());
	}
	/////////////////////////////////////////
	//surrounded by walkway cells
	
	@Test
	public void testAdjacencyW6()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(5, 22));
		assertTrue(testList.contains(board.calcIndex(5, 23)));
		assertTrue(testList.contains(board.calcIndex(5, 21)));
		assertTrue(testList.contains(board.calcIndex(4, 22)));
		assertTrue(testList.contains(board.calcIndex(6, 22)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacencyR19()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(18, 17));
		assertTrue(testList.contains(board.calcIndex(18, 16)));
		assertTrue(testList.contains(board.calcIndex(18, 18)));
		assertTrue(testList.contains(board.calcIndex(17, 17)));
		assertTrue(testList.contains(board.calcIndex(19, 17)));
		assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacencyQ9()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(8, 16));
		assertTrue(testList.contains(board.calcIndex(9, 16)));
		assertTrue(testList.contains(board.calcIndex(7, 16)));
		assertTrue(testList.contains(board.calcIndex(8, 17)));
		assertTrue(testList.contains(board.calcIndex(8, 15)));
		assertEquals(4, testList.size());
	}

/*  This one is not real.  it is just a template:
	@Test
	public void testAdjacencyW6()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(22, 22));
		assertTrue(testList.contains(brd.calcIndex(22, 23)));
		assertTrue(testList.contains(brd.calcIndex(22, 24)));
		assertTrue(testList.contains(brd.calcIndex(22, 22)));
		assertTrue(testList.contains(brd.calcIndex(22, 22)));
		assertEquals(4, testList.size());
	}
*/
	/////////////////////////////////////////
	//by doorways

	public void testAdjacencyU15()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(14, 20));
		assertTrue(testList.contains(board.calcIndex(14, 19)));
		assertTrue(testList.contains(board.calcIndex(14, 21)));
		assertTrue(testList.contains(board.calcIndex(13, 20)));
		assertTrue(testList.contains(board.calcIndex(15, 20)));
		assertEquals(4, testList.size());
	}

	public void testAdjacencyW18()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(17, 22));
		assertTrue(testList.contains(board.calcIndex(17, 21)));
		assertTrue(testList.contains(board.calcIndex(17, 23)));
		assertEquals(2, testList.size());
	}

	public void testAdjacencyA6()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(5, 0));
		assertTrue(testList.contains(board.calcIndex(5, 1)));
		assertTrue(testList.contains(board.calcIndex(4, 0)));
		assertEquals(2, testList.size());
	}

	/////////////////////////////////////////
	//by rooms but not doorways

	@Test
	public void testAdjacencyJ7()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(6, 9));
		assertTrue(testList.contains(board.calcIndex(6, 8)));
		assertTrue(testList.contains(board.calcIndex(6, 10)));
		assertTrue(testList.contains(board.calcIndex(5, 9)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacencyJ13()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(12, 9));
		assertTrue(testList.contains(board.calcIndex(12, 8)));
		assertTrue(testList.contains(board.calcIndex(13, 9)));
		assertTrue(testList.contains(board.calcIndex(11, 9)));
		assertEquals(3, testList.size());
	}


	@Test
	public void testAdjacencyQ21()
	{
		LinkedList<Integer> testList = board.getAdjList(board.calcIndex(20, 16));
		assertTrue(testList.contains(board.calcIndex(20, 17)));
		assertTrue(testList.contains(board.calcIndex(21, 16)));
		assertTrue(testList.contains(board.calcIndex(19, 16)));
		assertEquals(3, testList.size());
	}

	/////////////////////////////////////////
	//Targets along walkways
	
	@Test
	public void testTargetsP3()
	{
		board.calcTargets(board.calcIndex(2, 15), 3);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) board.getTargets();
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
	public void testTargetsT7()
	{
		board.calcTargets(board.calcIndex(6, 19), 4);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) board.getTargets();
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
	public void testTargetsZ18()
	{
		board.calcTargets(board.calcIndex(17, 25), 1);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(18, 25))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(17, 24))));
		assertEquals(2, targets.size());
	}
	@Test
	public void testTargetsH9()
	{
		board.calcTargets(board.calcIndex(8, 7), 3);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) board.getTargets();
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 7))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 8))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(8, 10))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(9, 9))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(10, 8))));
		assertTrue(targets.contains(board.getCellAt(board.calcIndex(11, 7))));
		assertEquals(6, targets.size());
	}

	
	
	
	/////connor work below this line
	

}
