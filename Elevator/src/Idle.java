
public class Idle implements ElevatorState {

	@Override
	public void movingUp(Elevator e) {
		e.changeState(new MovingUp());
	}

	@Override
	public void movingDown(Elevator e) {
		e.changeState(new MovingDown());
	}

	@Override
	public void idle(Elevator e) {
		System.out.println("Cannot change state from idle to idle");
	}

}
