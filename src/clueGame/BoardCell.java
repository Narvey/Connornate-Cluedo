package clueGame;

public abstract class BoardCell {
	protected int row, column;

	public boolean isWalkway() {
		return false;
	}

	public boolean isRoom() {
		return false;
	}

	public boolean isDoorway() {
		return false;
	}

	@Override
	public String toString() {
		return "Cell @ row=" + row + " column=" + column;
	}
}
