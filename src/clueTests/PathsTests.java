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
		assertEquals(brd.getNumColumns(), brd.calcIndex(1, 0));
	}
	
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
	public void testAdjacency4()
	{
		LinkedList<Integer> testList = brd.getAdjList(4);
		assertTrue(testList.contains(0));
		assertTrue(testList.contains(8));
		assertTrue(testList.contains(5));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacency10()
	{
		LinkedList<Integer> testList = brd.getAdjList(10);
		assertTrue(testList.contains(9));
		assertTrue(testList.contains(6));
		assertTrue(testList.contains(11));
		assertTrue(testList.contains(14));
		assertEquals(4, testList.size());
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
