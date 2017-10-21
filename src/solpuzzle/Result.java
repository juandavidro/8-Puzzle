package solpuzzle;


public class Result{	
	
	private int[][] copiar(int [][]_state) {
		int[][] nState = new int[3][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				nState[i][j] = _state[i][j];
			}
		}
		return nState;
	}	
	
	private Tuple findPos(int[][] _state) {
		for(int i =0; i<3;i++) 
			for (int j=0; j<3;j++) 
				if (_state[i][j] == 0) 
					return new Tuple(i,j);
		return new Tuple();
	}
	
	private int[][] findState(State _state, Action _action) {
		
		Tuple pos = findPos(_state.getBoardState());
		int[][] auxp = copiar(_state.getBoardState());
		
		if ( _action.getCode().equals("UP")) {
			System.out.println("UP");
			int aux = auxp[pos.getX()-1][pos.getY()];
			auxp[pos.getX()-1][pos.getY()] = auxp[pos.getX()][pos.getY()];
			auxp[pos.getX()][pos.getY()] = aux;
			return auxp;			
		}
		
		else if ( _action.getCode().equals("DOWN")) {
			//System.out.println("DOWN");
			int aux = auxp[pos.getX()+1][pos.getY()];
			auxp[pos.getX()+1][pos.getY()] = auxp[pos.getX()][pos.getY()];
			auxp[pos.getX()][pos.getY()] = aux;
			return auxp;			
		}
		
		else if ( _action.getCode().equals("RIGHT")) {
			//System.out.println("RIGTH");
			int aux = auxp[pos.getX()][pos.getY()+1];
			auxp[pos.getX()][pos.getY()+1] = auxp[pos.getX()][pos.getY()];
			auxp[pos.getX()][pos.getY()] = aux;
			return auxp;			
		}
		
		else {
			int aux = auxp[pos.getX()][pos.getY()-1];
			//System.out.println("LEFT");
			auxp[pos.getX()][pos.getY()-1] = auxp[pos.getX()][pos.getY()];
			auxp[pos.getX()][pos.getY()] = aux;
			return auxp;			
		}
	}
	
	
	public State apply(State _state, Action _action) {
		
		if( _action.getCode().equals("UP")) {
			State up = new State(findState( _state, _action));
			return up;
		}
		
		else if( _action.getCode().equals("DOWN")) {
			State down = new State(findState( _state, _action));
			return down;
		}
		
		else if( _action.getCode().equals("RIGHT")) {
			State right = new State(findState( _state, _action));
			return right;
		}
		
		else {
			State left = new State(findState( _state, _action));
			return left;
		}
	}

}
