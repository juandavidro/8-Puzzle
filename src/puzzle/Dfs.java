package puzzle;

import java.util.*;

public class Dfs {
	static Set<Integer> v = new HashSet<Integer>();
	static Stack<Node> st = new Stack<Node>();
	static int [][]goal = {{1,2,3},{4,5,6},{7,8,0}};
	static Node nGoal = new Node(goal);
	static int time;
	
	
	private static void Dfsvisit(Node _h) {
		
		if(_h.getState() == nGoal.getState()) {
			_h.path();
		}else {			
			Queue<Node> childs = new LinkedList<Node>();
			st.push(_h);
			childs = _h.generate();			
			int key;
			key = _h.getState();
			v.add(key);
			
			time += 1;
			System.out.println(_h);
			while(childs.peek() != null) {
				if(!v.contains(childs.peek().getState())) {
					try {
						Dfsvisit(childs.poll());
					} catch (Exception e) {
						System.out.println("here");
					}
				}else
					childs.poll();
			}
			st.pop();
		}
	}
	
	public static void main(String[] args) {
	
		Node start = new Node();
		v.add(-1);
		System.out.println("--");
		System.out.println(start);
		time = 1;			
		Node h = start;
		if(h.getState() != nGoal.getState())
			System.out.println("diferentes");
		Dfsvisit(h);	
		System.out.println("end"+time);
	}	
}
