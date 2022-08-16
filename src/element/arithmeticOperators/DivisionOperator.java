package element.arithmeticOperators;

import element.AbstractOperator;
import userMessages.ExpressionException;

public final class DivisionOperator extends AbstractOperator {
	private final static DivisionOperator operator = new DivisionOperator();
	private final int PRIORITY = 50;
	private final Character SYMBOL= '/';

	public static DivisionOperator getInstance() {
		return operator;
	}

	private DivisionOperator() {
	}

	@Override
	public double solve(Double leftElement, Double rightElement) throws ExpressionException {
		if (rightElement == 0) {
			throw new ExpressionException("It's impossible to divide by zero");
		} else {
			return leftElement / rightElement;
		}
	}
	@Override
	public Integer getPriority() {
		return PRIORITY;
	}

	@Override
	public Character getSymbol() {
		return SYMBOL;
	}
}
