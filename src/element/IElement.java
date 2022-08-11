package element;

import binaryTree.BinaryTree;

public interface IElement {

	public TypeOfElement getTypeOfElement();
	
	public int getPriority();
	
	public double solve (BinaryTree leftNode, BinaryTree rightNode);
	
	public default boolean hasMorePriority(IElement toCompare) {
		return this.getPriority() > toCompare.getPriority();
	}
}




