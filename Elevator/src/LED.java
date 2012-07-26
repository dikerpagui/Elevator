
public class LED {
	Direction direction;
	
	LED()
	{
		this.direction=Direction.STATIONARY;
	}
	public Direction getDirection()
	{
		return this.direction;
	}
	public void changeDirection(Direction direction)
	{
		this.direction=direction;
	}
}
