package experiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IntBoard {
	private Map<Integer, LinkedList<Integer>> adjacencies;
	private Set<Integer> targets;
	private ArrayList<Boolean> seen;
	private int columns;
	private int rows;

	public IntBoard() {
		columns = 4;// for now, we hard code these.
		rows = 4;// Later, they will be read from a file.
		adjacencies = new TreeMap<Integer, LinkedList<Integer>>();
		targets = new TreeSet<Integer>();
		seen = new ArrayList<Boolean>();
		for (Integer i = 0; i < columns * rows; i++)
			seen.add(false);
		calcAdjacencies();
	}

	public void calcAdjacencies() {
		for (int i = 0; i < rows * columns; i++) {
			LinkedList<Integer> cells = new LinkedList<Integer>();
			
			int column = i % columns;
			int row = i / columns;
			
			if (column > 0) { // left
				cells.add(i - 1);
			}
			
			if (column < columns - 1) { // right
				cells.add(i + 1);
			}
			
			if (row > 0) { // up
				cells.add(i - columns);
			}
			
			if (row < rows - 1) { // down
				cells.add(i + columns);
			}
			
			adjacencies.put(i, cells);
		}
	}

	public void calcTargets(int startCell, int steps) {
		seen.set(startCell, true);
		if (steps == 0) {
			targets.add(startCell);
			seen.set(startCell, false);
		} else {
			steps--;
			for (Integer i : getAdjList(startCell)) {
				if (seen.get(i) == false) { // will need extra conditions eventually
					calcTargets(i, steps);
				}
			}
			seen.set(startCell, false);
		}
	}

	public TreeSet<Integer> getTargets() {
		return (TreeSet<Integer>) targets;
	}

	public LinkedList<Integer> getAdjList(int cell) {
		return adjacencies.get(cell);
	}

	public int calcIndex(int row, int col) {
		return row * columns + col;
	}
}
