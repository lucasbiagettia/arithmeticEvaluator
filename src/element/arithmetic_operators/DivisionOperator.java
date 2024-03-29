package element.arithmetic_operators;

import element.AbstractOperator;
import user_messages.ExceptionMessages;
import user_messages.ExpressionException;

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
			throw new ExpressionException(ExceptionMessages.divideByZero());
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
