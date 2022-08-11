package element;

public abstract class AbstractOperator implements IElement {
	
	public abstract AbstractOperator getInstance(Character theSymbol);
	
	public abstract Character getSymbol();
	
	public TypeOfElement getTypeOfElement() {
		TypeOfElement.OPERATOR;
	}
	
}
