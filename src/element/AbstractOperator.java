package element;

public abstract class AbstractOperator extends IElement {
	private Character symbol;
	
	public abstract Character getSymbol();
	
	public abstract AbstractOperator getInstance(Character theSymbol);
}
