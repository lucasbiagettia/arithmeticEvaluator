package element;

import userMessages.ExpressionException;

public class MultiplicationOperator extends Element{
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



}
