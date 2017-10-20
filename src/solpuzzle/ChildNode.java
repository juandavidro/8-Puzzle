package solpuzzle;

public class ChildNode {
	private Problem problem;
	private Node parent;
	private Action action;
	
	public ChildNode(Problem _problem, Node _parent, Action _action) {
		this.problem = _problem;
		this.parent = _parent;
		this.action = _action;
	}	
	
	public Node getChild() {
		Node child = new Node(null);
		child.setParent(parent);
		child.setPathCost(parent.getPathCost() + 1);
		child.setState(problem.getResult(parent.getState(), action));
		child.setAction(action);
		return child;
	}	
}
