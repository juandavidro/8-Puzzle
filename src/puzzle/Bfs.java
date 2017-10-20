package puzzle;

import java.util.*;



public class Bfs {	
	public static void main(String[] args) {
		
		Queue<Node> myQ=new LinkedList<Node>(); 
		Set<Integer> v = new HashSet<>();
		Queue<Node> childs = new LinkedList<Node>();
		
		Node start = new Node();
		int [][]goal = {{1,2,3},{4,5,6},{7,8,0}};
		Node nGoal = new Node(goal);
		v.add(-1);
		System.out.println(start);
		myQ.add(start);

		int cont = 0;
		
		while(!myQ.isEmpty()) {
			cont += 1;			
			Node h = myQ.poll();
			if(h.getState() == nGoal.getState()) {				
				System.out.println("end");
				System.out.println(h.getState());
				System.out.println(h.getDistance());
				h.path();
				break;
			}			
			if(!v.contains(h.getState())) {
				v.add(h.getState());				
				childs = h.generate();
				
								
				while(childs.peek() != null) {
					if(!v.contains(childs.peek().getState()))
						myQ.add(childs.poll());
					else
						childs.poll();
				}				
			}
		}
		System.out.println("end"+cont);
	}
}
