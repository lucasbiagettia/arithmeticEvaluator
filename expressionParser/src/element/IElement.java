package element;

import expressionManager.Solution;

public interface IElement {

	public TypeOfElement getTypeOfElement();
	
	public int getPriority();
	
	public void solveThis(IElement leftElement, IElement rightElement, Solution solution);
	
	public default boolean hasMorePriority(IElement toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




