
public class Request {
	int no;
	Direction direction;
	
	Request(Direction direction, int no)
	{
		this.no=no;
		this.direction=direction;
	}

	public int getNo()
	{
		return this.no;
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
}
