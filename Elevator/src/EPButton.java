
public class EPButton extends Button {
	
	int id;
	ElevatorPanel elevatorPanel;
	
	public EPButton(int id,ElevatorPanel elevatorPanel)
	{
		this.id=id;
		this.elevatorPanel= elevatorPanel;
	}
	public void press()
	{
		changeStatus(true);
		System.out.println("Request to Floor No : " + this.id);
		this.getElevatorPanel().getElevator().addRequest(this.id,null);
	}
	
	public ElevatorPanel getElevatorPanel()
	{
		return this.elevatorPanel;
	}
}
