package element.arithmeticOperators;

import element.AbstractOperator;

public class SubstractionOperator extends AbstractOperator{
	private final int priority = 10;
	
	
	@Override
	public double solve(Double leftElement, Double rightElement) {
		return leftElement - rightElement;
	}


	@Override
	public int getPriority() {
		return priority;
	}


	@Override
	public AbstractOperator getInstance(Character theSymbol) {
		
	}


	@Override
	public Character getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}



}
