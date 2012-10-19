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
	
	private static Board brd;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		brd = new Board();
		brd.loadConfigFiles("legend.csv","board.csv");
	}
	
	@Test
	public void ThisTestNeedsToPass(){//for scratch work.  not to be graded.
		assertEquals(brd.getNumColumns(), brd.calcIndex(1, 0)); 
		assertEquals(363, brd.calcIndex(13,brd.getNumColumns()-1));
		assertEquals(brd.calcIndex(25, 25),brd.getNumColumns()*brd.getNumRows()-1);
	}
	/////////////////////////////////////////
	//edges and corners
	@Test
	public void testAdjacencyA1()//These are named after the cell in the spreadsheet
	{
		LinkedList<Integer> testList = brd.getAdjList(0);
		assertTrue(testList.contains(brd.getNumColumns()));
		assertTrue(testList.contains(1));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacencyL1()
	{
		LinkedList<Integer> testList = brd.getAdjList(11);
		assertTrue(testList.contains(10));
		assertTrue(testList.contains(brd.calcIndex(1, 11)));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyA13()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(12, 0));
		assertTrue(testList.contains(brd.calcIndex(11, 0)));
		assertTrue(testList.contains(brd.calcIndex(12, 1)));
		assertTrue(testList.contains(brd.calcIndex(13, 0)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyZ14()
	{
		LinkedList<Integer> testList = brd.getAdjList(363);
		assertTrue(testList.contains(362));
		assertTrue(testList.contains(brd.calcIndex(12, 26)));
		assertTrue(testList.contains(brd.calcIndex(14, 26)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyN26()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(25, 11));
		assertTrue(testList.contains(brd.calcIndex(24, 11)));
		assertTrue(testList.contains(brd.calcIndex(25, 10)));
		assertTrue(testList.contains(brd.calcIndex(25, 12)));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacencyZ26()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(25, 25));
		assertTrue(testList.contains(brd.getNumColumns()*brd.getNumRows()-2));
		assertTrue(testList.contains(brd.calcIndex(24, 25)));
		assertEquals(2, testList.size());
	}
	/////////////////////////////////////////
	//surrounded by room cells
	@Test
	public void testAdjacencyJ4()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(3, 9));
		assertTrue(testList.contains(brd.calcIndex(3, 10)));
		assertTrue(testList.contains(brd.calcIndex(3, 8)));
		assertTrue(testList.contains(brd.calcIndex(2, 9)));
		assertTrue(testList.contains(brd.calcIndex(4, 9)));
		assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacencyW2()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(1, 22));
		assertTrue(testList.contains(brd.calcIndex(1, 23)));
		assertTrue(testList.contains(brd.calcIndex(1, 24)));
		assertTrue(testList.contains(brd.calcIndex(2, 22)));
		assertTrue(testList.contains(brd.calcIndex(0, 22)));
		assertEquals(4, testList.size());
	}
	/////////////////////////////////////////
	//surrounded by walkway cells
	
	@Test
	public void testAdjacencyW6()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(5, 22));
		assertTrue(testList.contains(brd.calcIndex(5, 23)));
		assertTrue(testList.contains(brd.calcIndex(5, 21)));
		assertTrue(testList.contains(brd.calcIndex(4, 22)));
		assertTrue(testList.contains(brd.calcIndex(6, 22)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacencyR19()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(18, 17));
		assertTrue(testList.contains(brd.calcIndex(18, 16)));
		assertTrue(testList.contains(brd.calcIndex(18, 18)));
		assertTrue(testList.contains(brd.calcIndex(17, 17)));
		assertTrue(testList.contains(brd.calcIndex(19, 17)));
		assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacencyQ9()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(8, 16));
		assertTrue(testList.contains(brd.calcIndex(9, 16)));
		assertTrue(testList.contains(brd.calcIndex(7, 16)));
		assertTrue(testList.contains(brd.calcIndex(8, 17)));
		assertTrue(testList.contains(brd.calcIndex(8, 15)));
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
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(14, 20));
		assertTrue(testList.contains(brd.calcIndex(14, 19)));
		assertTrue(testList.contains(brd.calcIndex(14, 21)));
		assertTrue(testList.contains(brd.calcIndex(13, 20)));
		assertTrue(testList.contains(brd.calcIndex(15, 20)));
		assertEquals(4, testList.size());
	}

	public void testAdjacencyW18()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(17, 22));
		assertTrue(testList.contains(brd.calcIndex(17, 21)));
		assertTrue(testList.contains(brd.calcIndex(17, 23)));
		assertEquals(2, testList.size());
	}

	public void testAdjacencyA6()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(5, 0));
		assertTrue(testList.contains(brd.calcIndex(5, 1)));
		assertTrue(testList.contains(brd.calcIndex(4, 0)));
		assertEquals(2, testList.size());
	}

	/////////////////////////////////////////
	//by rooms but not doorways

	@Test
	public void testAdjacencyJ7()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(6, 9));
		assertTrue(testList.contains(brd.calcIndex(6, 8)));
		assertTrue(testList.contains(brd.calcIndex(6, 10)));
		assertTrue(testList.contains(brd.calcIndex(5, 9)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacencyJ13()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(12, 9));
		assertTrue(testList.contains(brd.calcIndex(12, 8)));
		assertTrue(testList.contains(brd.calcIndex(13, 9)));
		assertTrue(testList.contains(brd.calcIndex(11, 9)));
		assertEquals(3, testList.size());
	}


	@Test
	public void testAdjacencyQ21()
	{
		LinkedList<Integer> testList = brd.getAdjList(brd.calcIndex(20, 16));
		assertTrue(testList.contains(brd.calcIndex(20, 17)));
		assertTrue(testList.contains(brd.calcIndex(21, 16)));
		assertTrue(testList.contains(brd.calcIndex(19, 16)));
		assertEquals(3, testList.size());
	}

	/////////////////////////////////////////
	//Targets along walkways
	
	@Test
	public void testTargetsP3()
	{
		brd.calcTargets(brd.calcIndex(2, 15), 3);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) brd.getTargets();
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(0, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(2, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(4, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(1, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(3, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(5, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(0, 16))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(2, 16))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(4, 16))));
		assertEquals(9, targets.size());
	}
	@Test
	public void testTargetsT7()
	{
		brd.calcTargets(brd.calcIndex(2, 15), 3);
		HashSet<BoardCell> targets = (HashSet<BoardCell>) brd.getTargets();
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(0, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(2, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(4, 14))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(1, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(3, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(5, 15))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(0, 16))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(2, 16))));
		assertTrue(targets.contains(brd.getCellAt(brd.calcIndex(4, 16))));
		assertEquals(9, targets.size());
	}
	
	
	
	
	/////connor work below this line
	

}
