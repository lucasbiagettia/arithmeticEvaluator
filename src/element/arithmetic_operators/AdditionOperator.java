package element.arithmetic_operators;

import element.AbstractOperator;

public final class AdditionOperator extends AbstractOperator {
	private static  AdditionOperator operator = new AdditionOperator();
	private static final int PRIORITY = 100;
	private static final Character SYMBOL = '+';

	public static AdditionOperator getInstance() {
		return operator;
	}

	private AdditionOperator() {
	}

	@Override
	public double solve(Double leftNode, Double rightNode) {
		return leftNode + rightNode;
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
