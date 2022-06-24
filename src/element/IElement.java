package element;

import binaryTree.BinaryTree;
import expressionManager.Solution;

public interface IElement {

	public TypeOfElement getTypeOfElement();
	
	public int getPriority();
	
	public abstract Solution solveThis (BinaryTree leftNode, BinaryTree rightNode, Solution solution);
	
	public default boolean hasMorePriority(IElement toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




