
public class MovingDown implements ElevatorState {

	@Override
	public void movingUp(Elevator e) {
		System.out.println("Cannot change state from moving down to moving up");
	}

	@Override
	public void movingDown(Elevator e) {
		System.out.println("Cannot change state from moving down to moving down");
	}

	@Override
	public void idle(Elevator e) {
		e.changeState(new Idle());
	}

}
