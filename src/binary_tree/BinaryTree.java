package binary_tree;

import element.IElement;
import user_messages.ExpressionException;

public class BinaryTree {
	Node firstNode;

	public void add(IElement theElement) {
		if (firstNode == null) {
			firstNode = new Node(theElement);
		} else {
			Node newNode = new Node(theElement);
			// In this case the root is this node and the oters "go" to the right branch
			if (!firstNode.getElement().hasMorePriority(newNode.getElement())) {
				newNode.setLeftBranch(firstNode);
				firstNode = newNode;
			} else {
				Node auxNode = firstNode;
				Node nextNode = firstNode.getRightBranch();
				// While the priority
				while (nextNode != null && nextNode.getElement().hasMorePriority(newNode.getElement())) {
					auxNode = auxNode.getRightBranch();
					nextNode = nextNode.getRightBranch();
				}
				auxNode.setRightBranch(newNode);
				newNode.setLeftBranch(nextNode);
			}
		}
	}

	public double inOrderResult() throws ExpressionException {
		return firstNode.solveBinaryTreeInOrder();
	}
}