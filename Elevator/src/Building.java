import java.util.ArrayList;

public class Building {
	
	String name;
	Elevator elevator;
	ArrayList<Floor> floors=new ArrayList<Floor>();
	
	Building(String name, int numFloors)
	{
		this.name=name;
		this.elevator=new Elevator(numFloors);
		
		for(int i=0; i<numFloors;i++)
			floors.add(new Floor(i,this.elevator));
		
		this.elevator.setFloors(this.floors);
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
	
}
