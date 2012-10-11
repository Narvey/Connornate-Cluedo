package clueGame;

public class RoomCell extends BoardCell {

	enum DoorDirection {
		NORTH, SOUTH, EAST, WEST, NONE
	}

	DoorDirection dir;

	@Override
	public boolean isRoom() {
		return true;
	}

	@Override
	public boolean isDoorway() {
		if (true) {
			return true;
		} else {
			return false;
		}
	}
}
