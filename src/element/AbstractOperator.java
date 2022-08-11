package element;

public abstract class AbstractOperator implements IElement {
	
	private Character symbol;
	
	public Character getSymbol() {
		return symbol;
	}
	
	public abstract AbstractOperator getInstance(Character theSymbol);
}
