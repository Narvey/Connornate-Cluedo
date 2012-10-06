package experiment;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class IntBoard {
	private Map<Integer, LinkedList<Integer>> adjacencies;
	private int COLS;
	private int ROWS;
	
	public IntBoard() {
		COLS=4;//for now, we hard code these.
		ROWS=4;//Later, they will be read from a file.  
		// TODO Do we need more here?
	}
	
	public void calcAdjacencies() {
		for(int i=0; i<ROWS*COLS;i++){
			//
		}
	}
	
	public void calcTargets(int startCell, int steps) {
		// TODO implement
	}
	
	public TreeSet<Integer> getTargets() {
		// TODO implement
		return new TreeSet<Integer>();
	}
	
	public LinkedList<Integer> getAdjList(int cell) {
		// TODO implement
		return new LinkedList<Integer>();
	}
	
	public int calcIndex(int row, int col) {
		return row*COLS+col;
	}
}
