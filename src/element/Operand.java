package element;

import userMessages.ExpressionException;

public class Operand extends IElement {
	Double value;
	
	public Operand (double theValue) {
		value = theValue;
	}
	
	@Override
	public boolean solveBoolean(Double leftElement, Double rightElement) throws ExpressionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double solveArithmetic(Double leftElement, Double rightElement) throws ExpressionException {
		return value;
	}

}
