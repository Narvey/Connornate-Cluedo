package experiment;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IntBoard {
	private Map<Integer, LinkedList<Integer>> adjacencies;
	private Set<Integer> targets;
	private int COLS;
	private int ROWS;
	
	public IntBoard() {
		COLS=4;//for now, we hard code these.
		ROWS=4;//Later, they will be read from a file.  
		adjacencies = new TreeMap<Integer, LinkedList<Integer>>();
		targets = new TreeSet<Integer>();
		calcAdjacencies();
	}
	
	public void calcAdjacencies() {
		for(int i=0; i<ROWS*COLS;i++){
			LinkedList<Integer> lst = new LinkedList<Integer>();
			int n = i-COLS;//neighbor (start by going up)
			if(n>=0)lst.add(n);
			n = i+COLS;//downstairs neighbor
			if(n<=ROWS*COLS)lst.add(n);
			n = i-1;//left neighbor
			/*Logic below seems stupid, but with integer division
			 * it actually determines the beginning of the row.
			 */
			if(n>=(i/COLS)*COLS)lst.add(n);
			n = i+1;//right neighbor
			/* Likewise, determine beg. of next row */
			if(n<(i/COLS + 1)*COLS)lst.add(n);
			adjacencies.put(i, lst);
		}
	}
	
	public void calcTargets(int startCell, int steps) {
		// TODO implement
	}
	
	public TreeSet<Integer> getTargets() {
		return (TreeSet<Integer>) targets;
	}
	
	public LinkedList<Integer> getAdjList(int cell) {
		return adjacencies.get(cell);
	}
	
	public int calcIndex(int row, int col) {
		return row*COLS+col;
	}
}
