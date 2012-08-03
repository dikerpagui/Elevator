
public class Close implements DoorState {

	@Override
	public void openDoor(Door d) {
		d.changeState(new Open());
		System.out.println("Door is Opened!");
	}

	@Override
	public void closeDoor(Door d) {
		System.out.println("Door is already Closed!");
	}

}
