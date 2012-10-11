package clueGame;

public abstract class BoardCell {
	private char cellType;

	public boolean isWalkway() {
		return false;
	}

	public boolean isRoom() {
		return false;
	}

	public boolean isDoorway() {
		return false;
	}

}
