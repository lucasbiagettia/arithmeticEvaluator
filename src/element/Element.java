package element;

import expressionManager.Solution;

public abstract class Element {
	private TypeOfElement typeOfElement;
	private int priority;
	private abstract int value;

	public TypeOfElement getTypeOfElement() {
		return this.typeOfElement;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void solveThis(Element leftElement, Element rightElement, Solution solution) {
		switch (this.typeOfElement) {
		case booleanOperator:
		break;
		case arithmeticOperator:
		break;
		case operand:
		break;
		case variable:
		break;
		}
	}
	
	public boolean hasMorePriority(Element toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




