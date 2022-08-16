package element.arithmeticOperators;

import element.AbstractOperator;

public final class MultiplicationOperator extends AbstractOperator {
	private static final MultiplicationOperator operator = new MultiplicationOperator();
	private static final Integer PRIORITY = 50;
	private static final Character SYMBOL = '*';

	public static MultiplicationOperator getInstance() {
		return operator;
	}

	private MultiplicationOperator() {
	}

	@Override
	public double solve(Double leftElement, Double rightElement) {
		return leftElement * rightElement;
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
