package search.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import search.problem.Problem;

public class NodeExpander<S, A> {

	protected boolean useParentLinks = true;

	public NodeExpander useParentLinks(boolean s) {
		useParentLinks = s;
		return this;
	}

	///////////////////////////////////////////////////////////////////////
	// expanding nodes

	/**
	 * Factory method, which creates a root node for the specified state.
	 */
	public Node<S, A> createRootNode(S state) {
		return new Node<>(state);
	}

	/**
	 * Computes the path cost for getting from the root node state via the
	 * parent node state to the specified state, creates a new node for the
	 * specified state, adds it as child of the provided parent (if
	 * {@link #useParentLinks} is true), and returns it.
	 */
	public Node<S, A> createNode(S state, Node<S, A> parent, A action, double stepCost) {
		Node<S, A> p = useParentLinks ? parent : null;
		return new Node<>(state, p, action, parent.getPathCost() + stepCost);
	}

	/**
	 * Returns the children obtained from expanding the specified node in the
	 * specified problem.
	 * 
	 * @return the children obtained from expanding the specified node in the
	 *         specified problem.
	 */
	public List<Node<S, A>> expand(Node<S, A> node, Problem<S, A> problem) {
		List<Node<S, A>> successors = new ArrayList<>();

		for (A action : problem.getActions(node.getState())) {
			S successorState = problem.getResult(node.getState(), action);

			double stepCost = problem.getStepCosts(node.getState(), action, successorState);
			successors.add(createNode(successorState, node, action, stepCost));
		}
		notifyNodeListeners(node);
		return successors;
	}

	///////////////////////////////////////////////////////////////////////
	// progress tracking

	/**
	 * All node listeners added to this list get informed whenever a node is
	 * expanded.
	 */
	private List<Consumer<Node<S, A>>> nodeListeners = new ArrayList<>();

	/**
	 * Adds a listener to the list of node listeners. It is informed whenever a
	 * node is expanded during search.
	 */
	
	public void addNodeListener(Consumer<Node<S, A>> listener) {
		nodeListeners.add(listener);
	}

	/**
	 * Removes a listener from the list of node listeners.
	 */
	public boolean removeNodeListener(Consumer<Node<S, A>> listener) {
		return nodeListeners.remove(listener);
	}

	protected void notifyNodeListeners(Node<S, A> node) {
		for (Consumer<Node<S, A>> listener : nodeListeners)
			listener.accept(node);
	}
}
