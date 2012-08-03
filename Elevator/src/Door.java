
public interface Door {
	public void openDoor();
	public void closeDoor();
	public void changeState(DoorState state);
	public DoorState getState();
}
