package element;

public interface IElement {

	public TypeOfElement getTypeOfElement();
	
	public int getPriority();
	
	public double solve (Double leftNode, Double rightNode);
	
	public default boolean hasMorePriority(IElement toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




