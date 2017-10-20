package puzzle;

import java.util.*;

public class Node {
	private int [][]puzzle = new int[3][3];
	private int distance;
	private Node prent;
	private int state;
	
	/*
	 * Constructors
	 */
	public Node() {
		this.distance = 0;
		this.prent = null;
		this.puzzle = init();
		this.state = this.getcState();
	}
	
	public Node( int[][] _puzzle, Node _p) {
		this.distance = _p.getDistance()+1;
		this.prent = _p;
		this.puzzle = _puzzle;
		this.state = this.getcState();
	}
	
	public Node( int[][] _puzzle) {
		this.distance = 0;
		this.prent = null;
		this.puzzle = _puzzle;
		this.state = this.getcState();
	}
		
	/*
	 * Generate random board
	 */	
	public int[][] init() {
		Set<Integer> numbers = new HashSet<>();
		Random r = new Random();
		int [][] pza = new int[3][3];
		int num;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				do {
					num = r.ints(1, 0, 9).findFirst().getAsInt();
				}while(numbers.contains(num));
				numbers.add(num);
				pza[i][j] = num;
			}
		}
		//this.puzzle = pza;
		int [][] pa = {{5,8,3},{4,7,0},{2,1,6}};
		return pa;
	}
	
	/*
	 * Generate node children 3830 4206
	 */	
	public Queue<Node> generate(){
		Queue<Node> childs = new LinkedList<Node>();
		if(up()!= null) {
			Node up = new Node(up(), this);
			childs.add(up);	
		}
		
			
		if(down()!= null) {
			Node down = new Node(down(), this);		
			childs.add(down);
		}
		if(right()!= null) {
			Node right = new Node(right(), this);
			childs.add(right);
		}
		if(left()!= null) {
			Node left = new Node(left(), this);
			childs.add(left);
		}
		
		return childs;
	}
	
	private int xpos() {
		for(int i =0; i<3;i++) 
			for (int j=0; j<3;j++) 
				if (puzzle[i][j] == 0) 
					return i;
		return -1;				
	}

	private int ypos() {
		for(int i =0; i<3;i++) 
			for (int j=0; j<3;j++) 
				if (puzzle[i][j] == 0) 
					return j;
		return -1;				
	}
	
	private void copiar(int [][]a) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				a[i][j] = puzzle[i][j];
			}
		}
	}
	
	private int[][] up() {
		int x = xpos();
		int y = ypos();
		if (x-1 >= 0) {
			int [][] paux = new int[3][3];
			copiar(paux);
			//paux = this.puzzle;
			int aux = paux[x-1][y];
			paux[x-1][y] = paux[x][y];
			paux[x][y] = aux;
			return paux;
		}else {
			return null;
		}
	}
	
	private int[][] down() {
		int x = xpos();
		int y = ypos();
		if (x+1 <= 2) {
			int [][] paux = new int[3][3];
			copiar(paux);
			int aux = paux[x+1][y];
			paux[x+1][y] = paux[x][y];
			paux[x][y] = aux;
			return paux;
		}else {
			return null;
		}
	}
	
	private int[][] right() {
		int x = xpos();
		int y = ypos();
		if (y+1 <= 2) {
			int [][] paux = new int[3][3];
			copiar(paux);
			int aux = paux[x][y+1];
			paux[x][y+1] = paux[x][y];
			paux[x][y] = aux;
			return paux;
		}else {
			return null;
		}
	}
	
	private int[][] left() {
		int x = xpos();
		int y = ypos();
		if (y-1 >= 0) {
			int [][] paux = new int[3][3];
			copiar(paux);
			int aux = paux[x][y-1];
			paux[x][y-1] = paux[x][y];
			paux[x][y] = aux;
			return paux;
		}else {
			return null;
		}
	}
	/*
	 * Generate path
	 */
	public void path() {
		Node a = this;
		
		while(a.getPrent()!=null) {
			System.out.println(a);
			a = a.getPrent();
		}
		System.out.println(a);
	}
	
	/*
	 * Get and toString methods
	 */
		
	public int getcState() {
		String a = "";
		String c = "";
		if(puzzle != null) {		
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {					
					c = Integer.toString(puzzle[i][j]);					
					a += c;
				}
			}
			int b = Integer.parseInt(a);
			return b;
		}else{return -1;}
	}
	
	public int getState() {
		return state;
	}
	
	public Node getPrent() {
		return prent;
	}
	
	public int getDistance() {
		return distance;
	}	
	
	//public int getState() {
		//return state;
	//}
	
	@Override
	public String toString() {
		String matriz = "";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				//String aux = Integer.toString(puzzle[i][j]);
				matriz += puzzle[i][j];
			}
			matriz += "\n";
		}
		return matriz; 
	}
}