package binaryTree;

import element.IElement;

public class Node {
	private IElement element;
	private Node leftBranch; 
	private Node rightBranch;

	public Node(IElement theElement) {
		element = theElement;
	}

	public IElement getElement() {
		return element;
	}

	public Node getLeftBranch() {
		return leftBranch;
	}

	public void setLeftBranch(Node leftBranch) {
		this.leftBranch = leftBranch;
	}

	public Node getRightBranch() {
		return rightBranch;
	}

	public void setRightBranch(Node rightBranch) {
		this.rightBranch = rightBranch;
	}
	
	public Double solveBinary() {
		Double leftValue = null;
		Double rightValue = null;
		try {
			leftValue = leftBranch.solveBinary();
		}catch (NullPointerException e){}
		try {
			rightValue = rightBranch.solveBinary();
		}catch (NullPointerException e){}
		return element.solve(leftValue,rightValue);
	}

}
