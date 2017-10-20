package solpuzzle;

public class Node implements Comparable<Node> {
	
		private State state;
		private Node parent;
		private int pathCost;
		private Action action;

		/**
		 * Constructs a node with the specified state.
		 * 
		 * @param state
		 *            the state in the state space to which the node corresponds.
		 */
		public Node(State state) {
			this.state = state;
			this.parent = null;
			this.pathCost = 0;
			this.action = null;
		}

		/**
		 * Constructs a node with the specified state, parent, action, and path
		 * cost.
		*/
		public Node(State _state, Node _parent, int _pathCost, Action _action) {
			this.state = _state;
			this.parent = _parent;
			this.pathCost = _pathCost;
			this.action = _action;
		}

		/**
		 * Returns the state in the state space to which the node corresponds.
		 * 
		 * @return the state in the state space to which the node corresponds.
		 */
		public State getState() {
			return state;
		}
		
		public void setState(State state) {
			this.state = state;
		}

		/**
		 * Returns this node's parent node, from which this node was generated.
		 * 
		 * @return the node's parenet node, from which this node was generated.
		 */
		public Node getParent() {
			return parent;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}

		/**
		 * Returns the cost of the path from the initial state to this node as
		 * indicated by the parent pointers.
		 * 
		 * @return the cost of the path from the initial state to this node as
		 *         indicated by the parent pointers.
		 */
		public int getPathCost() {
			return pathCost;
		}
		
		public void setPathCost(int pathCost) {
			this.pathCost = pathCost;
		}
		
		public Action getAction() {
			return action;
		}
		
		public void setAction(Action action) {
			this.action = action;
		}

		/**
		 * Returns <code>true</code> if the node has no parent.
		 * 
		 * @return <code>true</code> if the node has no parent.
		 */
		public boolean isRootNode() {
			return parent == null;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public String toString() {
			return "Action=  "+getAction().getCode()+"state=" + getState().getCurrentState() + ", pathCost=" + pathCost + "]";
		}		
}
