package element.booleanOperators;

import binaryTree.BinaryTree;
import element.AbstractOperator;
import element.TypeOfElement;
import expressionManager.Solution;
import userMessages.ExpressionException;

public class EqualsOperator extends AbstractOperator{
	private final TypeOfElement typeOfElement = TypeOfElement.arithmeticOperator;
	private final int priority = 50;
	private final int value = (Integer) null;
	
	@Override
	public boolean solveBoolean(Double leftElement, Double rightElement) throws ExpressionException {
		//TODO definir expresión
		throw new ExpressionException("Error");
	}

	@Override
	public double solveArithmetic(Double leftElement, Double rightElement) {
		return leftElement * rightElement;
	}

	@Override
	public AbstractOperator getInstance(Character theSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solution solve(BinaryTree leftNode, BinaryTree rightNode, Solution solution) {
		// TODO Auto-generated method stub
		return null;
	}



}
