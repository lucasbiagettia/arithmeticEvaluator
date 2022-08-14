package element.arithmeticOperators;

import binaryTree.BinaryTree;
import element.AbstractOperator;
import element.IElement;
import element.TypeOfElement;
import userMessages.ExpressionException;

public final class AdditionOperator extends AbstractOperator{
	private final AdditionOperator operator = new AdditionOperator();
	private final int priority = 10;
	private final Character symbol = '+';
		
	@Override
	public IElement getInstance() {
		return operator;
	}
	
	private AdditionOperator() {}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double solve(Double leftNode, Double rightNode) {
		return leftNode + rightNode;
	}

	@Override
	public static AbstractOperator getInstance(Character theSymbol) {
		if (additionOperator == null) {
			additionOperator = new AdditionOperator();
		}
		return additionOperator;
	}

	@Override
	public Character getSymbol() {
		return '+';
	}
		

}
