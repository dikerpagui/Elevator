import java.util.ArrayList;

public class ElevatorPanel extends Panel{
	
	ArrayList<EPButton> buttonsToFloors=new ArrayList<EPButton>();
	Elevator elevator;
	
	ElevatorPanel(Elevator elevator,int numFloors)
	{
		this.led=new LED();
		this.elevator=elevator;
		for(int i=0; i<numFloors; i++)
			buttonsToFloors.add(new EPButton(i,this));
		
	}
	
	public ArrayList<EPButton> getButtonsToFloors()
	{
		return this.buttonsToFloors;
	}
	
	public void changeLedDirection(Direction direction)
	{
		this.led.changeDirection(direction);
	}
	
	public Elevator getElevator()
	{
		return this.elevator;
	}
}
