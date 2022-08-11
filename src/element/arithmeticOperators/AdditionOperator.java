package element.arithmeticOperators;

import binaryTree.BinaryTree;
import element.AbstractOperator;
import element.IElement;
import element.TypeOfElement;
import expressionManager.Solution;
import userMessages.ExpressionException;

public class AdditionOperator extends AbstractOperator{
	private final TypeOfElement typeOfElement = TypeOfElement.arithmeticOperator;
	private final int priority = 10;
	private final int value = (Integer) null;
	
	@Override
	public boolean solveBoolean(Double leftElement, Double rightElement) throws ExpressionException {
		//TODO definir expresión
		throw new ExpressionException("Error");
	}

	@Override
	public double solveArithmetic(Double leftElement, Double rightElement) {
		return leftElement + rightElement;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solution solveThis(BinaryTree leftNode, BinaryTree rightNode, Solution solution) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractOperator getInstance(Character theSymbol) {
		// TODO Auto-generated method stub
		return null;
	}



}
