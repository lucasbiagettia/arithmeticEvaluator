package element.arithmeticOperators;

import element.AbstractOperator;
import element.IElement;

public final class SubstractionOperator extends AbstractOperator{
	private final SubstractionOperator operator = new SubstractionOperator();
	private final int priority = 10;
	private final Character symbol = '-';
	
	@Override
	public IElement getInstance() {
		return operator;
	}
	
	private SubstractionOperator() {}
	
	@Override
	public double solve(Double leftElement, Double rightElement) {
		return leftElement - rightElement;
	}


	@Override
	public int getPriority() {
		return priority;
	}





	@Override
	public Character getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}



}
