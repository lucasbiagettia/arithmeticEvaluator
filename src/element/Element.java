package element;

import userMessages.ExceptionMessages;
import userMessages.ExpressionException;

public abstract class Element {
	private TypeOfElement typeOfElement;
	private int priority;
	private int value;
	private char symbol;

	public TypeOfElement getTypeOfElement() {
		return this.typeOfElement;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public abstract boolean solveBoolean(Double leftElement, Double rightElement) throws ExpressionException;
	
	public abstract double solveArithmetic(Double leftElement, Double rightElement) throws ExpressionException;
	
	public double getValue () throws ExpressionException {
		if (typeOfElement == TypeOfElement.operand)
			return value;
		else {
			throw new ExpressionException(ExceptionMessages.syntaxError());
		}
	}
	
	public double getSymbol() throws ExpressionException {
		if (typeOfElement != TypeOfElement.operand)
			return symbol;
		else {
			throw new ExpressionException(ExceptionMessages.syntaxError());
		}
	}
	
	public boolean hasMorePriority(Element toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




