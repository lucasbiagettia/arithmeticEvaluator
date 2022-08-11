package element;

import binaryTree.BinaryTree;

public class Variable implements IElement{

	@Override
	public TypeOfElement getTypeOfElement() {
		return TypeOfElement.variable;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public double solve(BinaryTree leftNode, BinaryTree rightNode) {
		// TODO use a recursive function to solve the variable
		return 0;
	}
}
