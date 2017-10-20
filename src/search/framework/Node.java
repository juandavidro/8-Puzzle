package search.framework;

public class Node<S,A> {
	
		private S state;
		private Node<S, A> parent;
		private A action;
		private double pathCost;

		/**
		 * Constructs a node with the specified state.
		 * 
		 * @param state
		 *            the state in the state space to which the node corresponds.
		 */
		public Node(S state) {
			this.state = state;
			pathCost = 0.0;
		}

		/**
		 * Constructs a node with the specified state, parent, action, and path
		 * cost.
		*/
		public Node(S state, Node<S, A> parent, A action, double pathCost) {
			this(state);
			this.parent = parent;
			this.action = action;
			this.pathCost = pathCost;
		}

		/**
		 * Returns the state in the state space to which the node corresponds.
		 * 
		 * @return the state in the state space to which the node corresponds.
		 */
		public S getState() {
			return state;
		}

		/**
		 * Returns this node's parent node, from which this node was generated.
		 * 
		 * @return the node's parenet node, from which this node was generated.
		 */
		public Node<S, A> getParent() {
			return parent;
		}

		/**
		 * Returns the action that was applied to the parent to generate the node.
		 * 
		 * @return the action that was applied to the parent to generate the node.
		 */
		public A getAction() {
			return action;
		}

		/**
		 * Returns the cost of the path from the initial state to this node as
		 * indicated by the parent pointers.
		 * 
		 * @return the cost of the path from the initial state to this node as
		 *         indicated by the parent pointers.
		 */
		public double getPathCost() {
			return pathCost;
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
		public String toString() {
			return "[parent=" + parent + ", action=" + action + ", state=" + getState() + ", pathCost=" + pathCost + "]";
		}

}
