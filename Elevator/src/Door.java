
public class Door {
	
	boolean state;
	
	Door()
	{
		this.state=false;
	}
	public void openDoor()
	{
		if(this.state != true)
			this.state=true;
		
		System.out.println("Door is Opened!");
	}
	public void closeDoor()
	{
		if(this.state != false)
			this.state=false;
		
		System.out.println("Door is Closed!");
	}
	public boolean getState()
	{
		return this.state;
	}
	
}
