package solpuzzle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSearch {
	
	
	private Problem problem;
	private Queue<Node> fronteir;
	private Set<Integer> sFront;
	private Set<Integer> explored;
	private Node initNode;
	
	public BFSearch(Problem _problem) {
		this.problem = _problem;
		this.fronteir = new LinkedList<>();
		this.sFront = new HashSet<>();
		this.explored = new HashSet<>();
		this.initNode = new Node(_problem.getInitialState());
	}
	
	public Node search() {
		
		ChildNode child;
		Node newCh;
		
		if(problem.getGoalt().compare(initNode.getState())) {
			return initNode;
		}
		
		fronteir.add(initNode);
		sFront.add(initNode.getState().getCurrentState());
		while(!fronteir.isEmpty()) {
			
			Node current = fronteir.poll();
			explored.add(current.getState().getCurrentState());
			ArrayList<Action> _actions = problem.get_Actions(current.getState());
			for (Action action : _actions) {
				child = new ChildNode(problem, current, action);
				newCh = child.getChild();
				
				if(!explored.contains(newCh.getState().getCurrentState())) {
					if(!sFront.contains(newCh.getState().getCurrentState())) {
						if(problem.getGoalt().compare(newCh.getState())) {
							return newCh;
						}
						fronteir.add(newCh);
						sFront.add(newCh.getState().getCurrentState());
					}					
				}
			}
		}
		return null;		
	}	
}
