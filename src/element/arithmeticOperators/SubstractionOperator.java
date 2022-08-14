package element.arithmeticOperators;

import element.AbstractOperator;
import element.IElement;

public final class SubstractionOperator extends AbstractOperator {
	private static final SubstractionOperator operator = new SubstractionOperator();
	private static final Integer PRIORITY = 10;
	private static final Character SYMBOL = '-';

	public static SubstractionOperator getInstance() {
		return operator;
	}

	private SubstractionOperator() {
	}

	@Override
	public double solve(Double leftElement, Double rightElement) {
		if (leftElement == null) {
			leftElement = 0.;
		}
		return leftElement - rightElement;
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
