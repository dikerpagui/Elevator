
public class Floor {

		int id;
		Door door;
		FloorPanel fp;
		Elevator elevator;
		
		public Floor(int id,Elevator elevator)
		{
			this.id=id;
			this.door=new Door();
			this.elevator=elevator;
			this.fp=new FloorPanel(this, this.elevator);
		}
		
		public Door getDoor()
		{
			return this.door;
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
}
