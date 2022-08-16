package binaryTree;

import element.IElement;
import userMessages.ExpressionException;

public class BinaryTree implements IBinaryTree {
	private IElement element;
	private BinaryTree leftBranch;
	private BinaryTree rightBranch;


	public BinaryTree add(IElement theElement) {
		if (this.element == null) {
			this.element = theElement;
			return this;
		} else {
			
			BinaryTree actualNode = new BinaryTree();
			actualNode.add(theElement);
			// En este caso se mueve la raiz hacia este nodo y lo demás es agregado al
			// brazo derecho
			// TODO implement compareTo method
			
			if (!this.element.hasMorePriority(actualNode.element)) {
				actualNode.leftBranch = this;
				return actualNode;
			} else {
				BinaryTree auxNode = this;
				BinaryTree nextNode = this.rightBranch;
				// Mientras la prioridad del de la izquierda sea mayor sigo bajando
				while (nextNode != null && nextNode.element.hasMorePriority(actualNode.element)) {
					auxNode = auxNode.rightBranch;
					nextNode = nextNode.rightBranch;
				}
				auxNode.rightBranch = actualNode;
				actualNode.leftBranch = nextNode;
				return this;
			}
		}
	}
	
	public void inOrderPrinter() {
		if (element == null) {
			System.out.print("null");
		}else {
			System.out.print(element);
		}
		System.out.println(" ");
		if (leftBranch ==null) {
			System.out.print("null");
		}else {
			leftBranch.inOrderPrinter();
		}
		if (rightBranch ==null) {
			System.out.print("null");
		}else {
			rightBranch.inOrderPrinter();
		}
	}

	public double inOrderResult() throws ExpressionException {
//		if (leftBranch == null) {
//			return element.solve(null, rightBranch.inOrderResult());
//
//		} else if (rightBranch == null) {
//			return element.solve(leftBranch.inOrderResult(), null);
//		} else if (rightBranch == null && leftBranch == null) {
//			return element.solve(null, null);
//		} else {

			return element.solve(leftBranch.inOrderResult(), rightBranch.inOrderResult());

//		}

	}
}