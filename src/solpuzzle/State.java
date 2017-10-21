package solpuzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class State {
	private int[][]boardState = new int[3][];
	
	//Constructor whit init() method
	public State() {
		this.boardState = init();		
	}
	
	public State(int[][] _state){
		this.boardState = _state;
	}
	
	public State(int[][] _state, int action) {
		this.boardState = init();		
	}
	
	
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
		return pza;
	}
	
	public String getCurrentState() {
		String a = "";
		String c = "";
		if(boardState != null) {		
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {					
					c = Integer.toString(boardState[i][j]);					
					a += c;
				}
			}
			//int b = Integer.parseInt(a);
			return a;
		}else{
			return null;
		}
	}
	
	
	
	public int[][] getBoardState() {
		return boardState;
	}
	
}