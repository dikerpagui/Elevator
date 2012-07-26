
public class MovingUp implements ElevatorState {

	@Override
	public void movingUp(Elevator e) {
		
	}

	@Override
	public void movingDown(Elevator e) {
		System.out.println("Cannot change state from moving up to moving down");
	}

	@Override
	public void idle(Elevator e) {
		e.changeState(new Idle());
	}

}
