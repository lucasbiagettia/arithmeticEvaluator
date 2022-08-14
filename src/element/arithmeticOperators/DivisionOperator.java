package element.arithmeticOperators;

import element.IElement;
import element.TypeOfElement;
import userMessages.ExpressionException;

public class DivisionOperator extends IElement{
	private final TypeOfElement typeOfElement = TypeOfElement.arithmeticOperator;
	private final int priority = 50;
	private final int value = (Integer) null;
	
	@Override
	public boolean solveBoolean(Double leftElement, Double rightElement) throws ExpressionException {
		//TODO definir expresión
		throw new ExpressionException("Error");
	}

	@Override
	public double solve(Double leftElement, Double rightElement) throws ExpressionException {
		if (rightElement == 0) {
			throw new ExpressionException("It's impossible to divide by zero");
		}else {
		return leftElement / rightElement;
		}
	}
}
