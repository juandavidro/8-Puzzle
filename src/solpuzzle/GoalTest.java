package solpuzzle;

public class GoalTest {
	
	private final State s;
	
	public GoalTest() {
		int [][]goal = {{1,2,3},{4,5,6},{7,8,0}};
		this.s  = new State(goal);
	}
	
	public boolean compare(State _state) {
		if(s.getCurrentState() == _state.getCurrentState())
			return true;
		else
			return false;

	}
	
	
}
