package element.arithmeticOperators;

import element.AbstractOperator;
import element.IElement;
import element.TypeOfElement;
import userMessages.ExpressionException;

public final class DivisionOperator extends AbstractOperator{
	private final DivisionOperator operator = new DivisionOperator();
	private final int priority = 50;
	private final Character symbol = '/';
	
	@Override
	public IElement getInstance() {
		return operator;
	}
	
	private DivisionOperator() {}
	
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
