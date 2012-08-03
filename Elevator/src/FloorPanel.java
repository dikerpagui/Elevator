
public class FloorPanel extends Panel {

	FPButton up;
	FPButton down;
	Floor floor;
	Elevator elevator;
	
	FloorPanel(Floor floor,Elevator elevator)
	{
		this.elevator=elevator;
		this.floor=floor;
		this.up=new FPButton(Direction.UP,this);
		this.down=new FPButton(Direction.UP,this);
		this.led=new LED();
	}
	
	public void changeLedDirection(Direction direction)
	{
		this.led.changeDirection(direction);
	}
	
	public FPButton getUpButton()
	{
		return this.up;
	}
	
	public FPButton getDownButton()
	{
		return this.down;
	}
	
	public Floor getFloor()
	{
		return this.floor;
	}
	public Elevator getElevator()
	{
		return this.elevator;
	}
}
