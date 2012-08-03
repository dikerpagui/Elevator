
public class ElevatorDoor implements Door{
	
	DoorState state;
	Elevator elevator;
	
	ElevatorDoor(Elevator elevator)
	{
		this.elevator=elevator;
		state=new Close();
	}
	public void openDoor()
	{
		this.state.openDoor(this);
		
		//Opening Floor Door..
		this.getElevator().getFloors().get(this.getElevator().getCurPos()).getDoor().openDoor();
	}
	public void closeDoor()
	{
		this.state.closeDoor(this);
		
		//Closing Floor Door..
		this.getElevator().getFloors().get(this.getElevator().getCurPos()).getDoor().closeDoor();
	}
	public void changeState(DoorState state)
	{
		this.state=state;
	}
	
	public DoorState getState()
	{
		return this.state;
	}
	protected Elevator getElevator()
	{
		return this.elevator;
	}
}
