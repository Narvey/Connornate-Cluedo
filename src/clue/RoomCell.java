package clue;


public class RoomCell extends BoardCell {

	enum DoorDirection{
		NORTH,SOUTH,EAST,WEST,NONE
	}
	DoorDirection dir;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isRoom(){
		return true;
	}
	public boolean isDoorway(){
		if(true){ 
			return true;
		}else return false;
	}
}
