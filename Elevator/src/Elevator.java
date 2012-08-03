import java.util.ArrayList;

public class Elevator extends Part implements Publisher{
	
		ElevatorPanel ep;
		int curPos;
		ArrayList<Floor> floors=new ArrayList<Floor>();
		ArrayList<Request> requests=new ArrayList<Request>();
		ElevatorState elavatorState;
		
		Elevator(int numFloors)
		{
			this.curPos=0;
			ep=new ElevatorPanel(this,numFloors);
			door=new ElevatorDoor(this);
			elavatorState=new Idle();
		}
		@Override
		public void attachFloors(ArrayList<Floor> floors)
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
		protected void moveUp()
		{
			this.getElevatorPanel().getLED().changeDirection(Direction.UP);
			this.movingUp(); //Elevator is in moving Up State.
			for(int i=this.curPos; i >= this.getRequests().get(0).getNo(); i--)
			{
				this.curPos=i;
				System.out.println("Cur Pos: "+ this.curPos);
			}
		}
		protected void moveDown()
		{
			this.getElevatorPanel().getLED().changeDirection(Direction.DOWN);
			this.movingDown(); //Elevator is in moving Down State.
			for(int i=this.curPos; i <= this.getRequests().get(0).getNo(); i++)
			{
				this.curPos=i;
				System.out.println("Cur Pos: "+ this.curPos);
			}
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
				
				this.idle(); //Elevator Idle State.
				
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
			
			this.getDoor().closeDoor();
		}
		
		public void changeState(ElevatorState eState) {
			this.elavatorState=eState;
		
		}
		
		public void movingUp()
		{
			this.elavatorState.movingUp(this);
		}
		public void movingDown()
		{
			this.elavatorState.movingDown(this);
		}
		public void idle()
		{
			this.elavatorState.idle(this);
		}
		
		@Override
		public void notifyFloors() {
			
			for(int i=0; i<this.floors.size();i++)
			{
				this.floors.get(i).setElevatorPosition(this.getCurPos());
			}
		}
}


