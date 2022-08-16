package binaryTree;

import element.IElement;
import userMessages.ExpressionException;

public class BinaryTree implements IBinaryTree {
	Node firstNode;



	public void add(IElement theElement) {
		if (firstNode == null) {
			firstNode = new Node(theElement);
		}else {			
			Node newNode = new Node (theElement);
			// En este caso se mueve la raiz hacia este nodo y lo demás es agregado al
			// brazo derecho
			// TODO implement compareTo method
			if (!firstNode.getElement().hasMorePriority(newNode.getElement())) {
				newNode.setLeftBranch(firstNode);
				firstNode = newNode;
			} else {
				Node auxNode = firstNode;
				Node nextNode = firstNode.getRightBranch();
				// Mientras la prioridad del de la izquierda sea mayor sigo bajando
				while (nextNode != null && nextNode.getElement().hasMorePriority(newNode.getElement())) {
					auxNode = auxNode.getRightBranch();
					nextNode = nextNode.getRightBranch();
				}
				auxNode.setRightBranch(newNode);
				newNode.setLeftBranch (nextNode);
//				return this;
			}
		}
	}
	
//	public void inOrderPrinter() {
//		if (element == null) {
//			System.out.print("null");
//		}else {
//			System.out.print(element);
//		}
//		System.out.println(" ");
//		if (leftBranch ==null) {
//			System.out.print("null");
//		}else {
//			leftBranch.inOrderPrinter();
//		}
//		if (rightBranch ==null) {
//			System.out.print("null");
//		}else {
//			rightBranch.inOrderPrinter();
//		}
//	}

	public double inOrderResult() throws ExpressionException {
//		if (leftBranch == null) {
//			return element.solve(null, rightBranch.inOrderResult());
//
//		} else if (rightBranch == null) {
//			return element.solve(leftBranch.inOrderResult(), null);
//		} else if (rightBranch == null && leftBranch == null) {
//			return element.solve(null, null);
//		} else {

			return firstNode.solveBinary();

//		}

	}
}