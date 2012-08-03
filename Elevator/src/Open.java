
public class Open implements DoorState {

	@Override
	public void openDoor(Door d) {
		System.out.println("Door is already Opened!");
	}

	@Override
	public void closeDoor(Door d) {
		d.changeState(new Close());
		System.out.println("Door is Closed!");
	}

}
