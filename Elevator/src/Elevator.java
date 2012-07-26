import java.util.ArrayList;

public class Elevator {

		Door door;
		ElevatorPanel ep;
		int curPos;
		ArrayList<Floor> floors=new ArrayList<Floor>();
		ArrayList<Request> requests=new ArrayList<Request>();
		ElevatorState elavatorState;
		
		Elevator(int numFloors)
		{
			this.curPos=0;
			ep=new ElevatorPanel(this,numFloors);
			door=new Door();
			
		}
		public void setFloors(ArrayList<Floor> floors)
		{
			this.floors=floors;
		}
		public ArrayList<Floor> getFloors()
		{
			return this.floors;
		}
		
		public ElevatorPanel getElevatorPanel()
		{
			return this.ep;
		}
		public void move()
		{	
			if(this.curPos > this.getRequests().get(0).getNo())
				moveUp();
			else
				moveDown();
			
		}
		public void moveUp()
		{
			for(int i=this.curPos; i >= this.getRequests().get(0).getNo(); i--)
			{
				this.curPos=i;
				this.getElevatorPanel().getLED().changeDirection(Direction.UP);
				System.out.println("Cur Pos: "+ this.curPos);
			}
		}
		public void moveDown()
		{
			for(int i=this.curPos; i <= this.getRequests().get(0).getNo(); i++)
			{
				this.curPos=i;
				this.getElevatorPanel().getLED().changeDirection(Direction.DOWN);
				System.out.println("Cur Pos: "+ this.curPos);
			}
		}
		public Door getDoor()
		{
			return this.door;
		}
		public int getCurPos()
		{
			return this.curPos;
		}
		
		public void addRequest(int i, Direction direction)
		{
			this.requests.add(new Request(direction,i));
			this.handleRequest();
		}
		
		public void handleRequest()
		{
			while(this.getRequests().size()!=0)
			{
				this.move();
				setButtonStatusOff();
				
				System.out.println("Reached to Floor No: " + this.getCurPos());	
				this.removeRequest();
				
				this.getElevatorPanel().getLED().changeDirection(Direction.STATIONARY);
				processDoorFunctioning();			
			}
		}
		
		public void setButtonStatusOff()
		{
			if(this.getRequests().get(0).getDirection()!=null)
			{
				if(this.getRequests().get(0).getDirection()==Direction.UP)
					this.floors.get(this.getRequests().get(0).getNo()).getFloorPanel().getUpButton().changeStatus(false);
			
				if(this.getRequests().get(0).getDirection()==Direction.DOWN)
					this.floors.get(this.getRequests().get(0).getNo()).getFloorPanel().getDownButton().changeStatus(false);
			}
			else
			{
				this.getElevatorPanel().getButtonsToFloors().get(this.getRequests().get(0).getNo()).changeStatus(false);
			}
		}
		
		public void removeRequest()
		{
			if(requests.size()!=0)
				this.requests.remove(0);
		}
		
		public ArrayList<Request> getRequests()
		{
			return this.requests;
		}
		
		public void processDoorFunctioning()
		{
			//Opening and Closing Elevator and floor doors..
			this.getDoor().openDoor();
			floors.get(this.getCurPos()).getDoor().openDoor();
			this.getDoor().closeDoor();
			floors.get(this.getCurPos()).getDoor().closeDoor();
		}
		
		public void changeState(ElevatorState eState) {
			this.elavatorState=eState;
		
		}
		
	}


