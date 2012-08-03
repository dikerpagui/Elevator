import java.util.ArrayList;

public class Building {
	
	String name;
	Elevator elevator;
	ArrayList<Floor> floors=new ArrayList<Floor>();
	int numFloors;
	
	PartFactory partFactory;
	
	Building(String name, int numFloors)
	{
		//this.partFactory=new ElevatorFactory();
		
		this.name=name;
		this.numFloors=numFloors;
		this.elevator=new Elevator(numFloors);
		
		for(int i=0; i<numFloors;i++)
			floors.add(new Floor(i,this.elevator));
		
		this.elevator.attachFloors(this.floors);
	}

	public String getName() {
		return name;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public ArrayList<Floor> getFloors() {
		return floors;
	}
	public int getNumFloors()
	{
		return this.numFloors;
	}
}
