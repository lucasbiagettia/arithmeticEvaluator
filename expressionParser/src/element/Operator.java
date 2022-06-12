package element;

public abstract class Operator implements IElement{
	private final TypeOfElement typeOfElement = TypeOfElement.operator;

	public TypeOfElement getTypeOfElement() {
		return typeOfElement;
	}
}
