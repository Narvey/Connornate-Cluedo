package experiment;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class IntBoardTest {
	@Before
	public void setup() {
		board = new IntBoard();
	}

	@Test
	public void testCalcIndex() {
		assertEquals(0, board.calcIndex(0, 0));
		assertEquals(5, board.calcIndex(1, 1));
		assertEquals(7, board.calcIndex(1, 3));
	}

	@Test
	public void testAdjacency0()
	{
		LinkedList<Integer> testList = board.getAdjList(0);
		assertTrue(testList.contains(4));
		assertTrue(testList.contains(1));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency5()
	{
		LinkedList<Integer> testList = board.getAdjList(5);
		assertTrue(testList.contains(4));
		assertTrue(testList.contains(1));
		assertTrue(testList.contains(6));
		assertTrue(testList.contains(9));
		assertEquals(4, testList.size());
		//now make sure each of them has 5 in their adjacency list 
		assertTrue(board.getAdjList(4).contains(5));
		assertTrue(board.getAdjList(1).contains(5));
		assertTrue(board.getAdjList(6).contains(5));
		assertTrue(board.getAdjList(9).contains(5));		
	}
	@Test
	public void testAdjacency15()
	{
		LinkedList<Integer> testList = board.getAdjList(15);
		assertTrue(testList.contains(14));
		assertTrue(testList.contains(11));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacency7()
	{
		LinkedList<Integer> testList = board.getAdjList(7);
		assertTrue(testList.contains(3));
		assertTrue(testList.contains(6));
		assertTrue(testList.contains(11));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacency4()
	{
		LinkedList<Integer> testList = board.getAdjList(4);
		assertTrue(testList.contains(0));
		assertTrue(testList.contains(8));
		assertTrue(testList.contains(5));
		assertEquals(3, testList.size());
	}
	@Test
	public void testAdjacency10()
	{
		LinkedList<Integer> testList = board.getAdjList(10);
		assertTrue(testList.contains(9));
		assertTrue(testList.contains(6));
		assertTrue(testList.contains(11));
		assertTrue(testList.contains(14));
		assertEquals(4, testList.size());
	}

	@Test
	public void testTargets0_3()
	{
		board.calcTargets(0, 3);
		TreeSet<Integer> targets = board.getTargets();
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
		board.calcTargets(2, 2);
		TreeSet<Integer> targets = board.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(0));
		assertTrue(targets.contains(5));
		assertTrue(targets.contains(7));
		assertTrue(targets.contains(10));
	}
	
	@Test
	public void testTargets_0_5()
	{
		board.calcTargets(0, 5);
		TreeSet<Integer> targets = board.getTargets();
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
		board.calcTargets(9, 1);
		TreeSet<Integer> targets = board.getTargets();
		assertEquals(4, targets.size());
		for (Integer i : targets){
			assertTrue(board.getAdjList(i).contains(9));
		}
	}

	private IntBoard board;
}
