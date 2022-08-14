package element;


public class Operand implements IElement {
	Double value;
	private final static Integer PRIORITY = 0;
	
	public Operand (double theValue) {
		value = theValue;
	}

	@Override
	public TypeOfElement getTypeOfElement() {
		return TypeOfElement.OPERAND;
	}

	@Override
	public Integer getPriority() {
		return PRIORITY;
	}

	public double solve (Double leftNode, Double rightNode) {
		return value;
	}
}
