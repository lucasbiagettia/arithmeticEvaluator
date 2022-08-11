package element;

import userMessages.ExpressionException;

public class Operand implements IElement {
	Double value;
	
	public Operand (double theValue) {
		value = theValue;
	}
	
}
