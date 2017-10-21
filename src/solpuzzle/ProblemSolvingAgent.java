package solpuzzle;

public class ProblemSolvingAgent {
	public static void main(String[] args) {
		
		State initialState = new State();
		GoalTest goal = new GoalTest();
		Problem problem = new Problem(initialState, goal);
		BFSearch bfs = new BFSearch(problem);
		Node sol = bfs.search();
		System.out.println(sol);
		
	}
}
