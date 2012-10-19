package clueTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;

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

	
	
	
	@Test
	public void testTargets0_3()
	{
		brd.calcTargets(0, 3);
		TreeSet<Integer> targets = new TreeSet<Integer>();//= brd.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(12));
		assertTrue(targets.contains(9));
		assertTrue(targets.contains(1));
		assertTrue(targets.contains(6));
		assertTrue(targets.contains(3));
		assertTrue(targets.contains(4));
	}
	
	@Test
	public void testTargets2_2()
	{
		brd.calcTargets(2, 2);
		TreeSet<Integer> targets = new TreeSet<Integer>();// = brd.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(0));
		assertTrue(targets.contains(5));
		assertTrue(targets.contains(7));
		assertTrue(targets.contains(10));
	}
	
	@Test
	public void testTargets_0_5()
	{
		brd.calcTargets(0, 5);
		TreeSet<Integer> targets = new TreeSet<Integer>();// = brd.getTargets();
		assertEquals(8, targets.size());
		assertTrue(targets.contains(1));
		assertTrue(targets.contains(3));
		assertTrue(targets.contains(4));
		assertTrue(targets.contains(6));
		assertTrue(targets.contains(9));
		assertTrue(targets.contains(11));
		assertTrue(targets.contains(12));
		assertTrue(targets.contains(14));
	}
	
	@Test
	public void testTargets9_1()
	{
		brd.calcTargets(9, 1);
		TreeSet<Integer> targets = new TreeSet<Integer>();// = brd.getTargets();
		assertEquals(4, targets.size());
		for (Integer i : targets){
			assertTrue(brd.getAdjList(i).contains(9));
		}
	}

}
