package solpuzzle;

import java.util.ArrayList;


public class Actions{
		
	private Tuple findPos(int[][] _state) {
		for(int i =0; i<3;i++) 
			for (int j=0; j<3;j++) 
				if (_state[i][j] == 0) 
					return new Tuple(i,j);
		return new Tuple();
	}
	
	

	public ArrayList<Action> findState(State _state) {
		Tuple aux = findPos(_state.getBoardState());
		ArrayList<Action> sApply = new ArrayList<>();
		if(aux.getX() > 0) {
			Action up = new Action("UP");
			sApply.add(up);
		}
		if(aux.getX() < 2) {
			Action down = new Action("DOWN");
			sApply.add(down);
		}
		if(aux.getY() < 2) {
			Action right = new Action("RIGHT");
			sApply.add(right);
		}
		if(aux.getY() > 0) {
			Action left = new Action("LEFT");
			sApply.add(left);
		}
		
		return sApply;
	}

}
