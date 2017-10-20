package solpuzzle;

import java.util.ArrayList;

public class Problem {
	private State initialState;
	private Actions actions;
	private Result result;
	private GoalTest goalt;
	
	//Actions _actions, Result _result,
	
	public Problem(State _inState, GoalTest _goal) {
		this.initialState = _inState;
		this.actions = new Actions();
		this.result = new Result();
		this.goalt = _goal;
	}
	
	public State getInitialState() {
		return initialState;
	}
		
	public ArrayList<Action> get_Actions(State _state){
		ArrayList<Action> _actions = actions.findState(_state);
		return _actions;		
	}
	
	public GoalTest getGoalt() {
		return goalt;
	}
	
	public State getResult(State _state, Action _action) {
		State abs;
		abs = result.apply(_state, _action); 
		return abs;
	}	
}
