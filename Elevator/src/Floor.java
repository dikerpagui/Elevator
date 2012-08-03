
public class Floor extends Part implements Observer{

		int id;
		FloorPanel fp;
		Elevator elevator;
		int elevatorPosition;
		
		public Floor(int id,Elevator elevator)
		{
			this.id=id;
			this.door=new FloorDoor();
			this.elevator=elevator;
			this.fp=new FloorPanel(this, this.elevator);
			this.elevatorPosition=0;
		}
		
		public Elevator getElevator()
		{
			return this.elevator;
		}
		
		public FloorPanel getFloorPanel()
		{
			return this.fp;
		}
		
		public int getID()
		{
			return this.id;
		}
		
		public void setElevatorPosition(int pos)
		{
			this.elevatorPosition=pos;
		}
		
}
