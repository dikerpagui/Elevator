
public class Client {

	public static void main(String[] args) {
		
		Building building=new Building("Hall de sa",10);
		
		building.getFloors().get(4).getFloorPanel().getUpButton().press();
		
		building.getElevator().getElevatorPanel().getButtonsToFloors().get(2).press();
	}

}
