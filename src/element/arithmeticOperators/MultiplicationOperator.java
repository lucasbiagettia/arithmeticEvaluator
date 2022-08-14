package element.arithmeticOperators;

import binaryTree.BinaryTree;
import element.AbstractOperator;
import element.IElement;
import element.TypeOfElement;
import expressionManager.Solution;
import userMessages.ExpressionException;

public final class MultiplicationOperator extends AbstractOperator{
	private final MultiplicationOperator operator = new MultiplicationOperator();
	private final int priority = 50;
	private final Character symbol = '*';
	

	@Override
	public IElement getInstance() {
		return operator;
	}
	
	private MultiplicationOperator() {}
	
	
	@Override
	public double solve(Double leftElement, Double rightElement) {
		return leftElement * rightElement;
	}



	@Override
	public Solution solve(BinaryTree leftNode, BinaryTree rightNode, Solution solution) {
		// TODO Auto-generated method stub
		return null;
	}



}
