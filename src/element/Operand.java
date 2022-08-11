package element;

import binaryTree.BinaryTree;

public class Operand implements IElement {
	Double value;
	
	public Operand (double theValue) {
		value = theValue;
	}

	@Override
	public TypeOfElement getTypeOfElement() {
		return TypeOfElement.OPERAND;
	}

	@Override
	public int getPriority() {
		return 10;
	}

	@Override
	public double solve(BinaryTree leftNode, BinaryTree rightNode) {
		return value;
	}
	
}
