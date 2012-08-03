
public class FloorDoor implements Door{
	
	DoorState state;
	
	FloorDoor()
	{
		state=new Close();
	}
	public void openDoor()
	{
		this.state.openDoor(this);
	}
	public void closeDoor()
	{
		this.state.closeDoor(this);
	}
	public void changeState(DoorState state)
	{
		this.state=state;
	}
	
	public DoorState getState()
	{
		return this.state;
	}
	
}
