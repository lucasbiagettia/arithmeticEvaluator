package element;

public abstract class AbstractOperator implements IElement {
	
	public abstract IElement getInstance();
	
	public abstract Character getSymbol();
	
	public TypeOfElement getTypeOfElement() {
		return TypeOfElement.OPERATOR;
	}	
}
