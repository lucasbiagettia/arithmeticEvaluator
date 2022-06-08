package binaryTree;

import java.util.Scanner;

import element.IElement;
import expressionManager.Expression;
import userMessages.ExpressionException;
import userMessages.UserMessages;


public class BinaryTree implements IBinaryTree {
	IElement element;
	BinaryTree leftBranch;
	BinaryTree rightBranch;

	public BinaryTree() {
		element = null;
		leftBranch = null;
		rightBranch = null;
	}

	public BinaryTree add (IElement element){
		if (this.element == null){
			this.element = element;
			return this;
		}
		else 
		{
			BinaryTree actualNode = new BinaryTree();
			actualNode.element=element;
			//En este caso se mueve la raiz hacia este nodo y lo demás es agregado al brazo derecho
			// TODO implement compareTo method
			if (this.element.getPriority() <= actualNode.element.getPriority()){
				actualNode.leftBranch = this;
				return actualNode;
			}else{
				BinaryTree auxNode = this;
				BinaryTree proxNode = this.rightBranch;
				// Mientras la prioridad del de la izquierda sea mayor sigo bajando
				while (proxNode != null && proxNode.element.getPriority() > actualNode.element.getPriority()) {
					auxNode = auxNode.rightBranch;
					proxNode = proxNode.rightBranch;
				}
				auxNode.rightBranch = actualNode;
				actualNode.leftBranch = proxNode;
				return this;
			}
		}
	}

	public double inOrderResult() throws ExpressionException {
		if (this != null) {
			switch (this.element.getTypeOfElement()){
			case operand :
				return this.element.getValue();

			case operator:
				return this.element.solveOperation(leftBranch.inOrderResult() , rightBranch.inOrderResult()) ;

			case variable:
				System.out.pr1neln (UserMessages.insterValueOfTheVariable(element.getVariableName()));
				Expression subExpression;
				try (Scanner scan = new Scanner(System.in)){
					String str = scan.nextLine ();
					subExpression = new Expression (str);
				}
				return subExpression.getFinalValue();
			default:
				break ;
			}
		}
		// TODO ver esta excepción
		throw new ExpressionException (ExceptionMessages.incompatibleElement( ));
	}


	public boolean inOrderComparison() throws ExpressionException {
		if (this.leftBranch == null || this.rightBranch == null) {
			throw new ExpressionException(ExceptionMessages.invalidOperation());
		} else {
			return this.leftBranch.InOrderResult() == this.rightBranch.InOrderResult();
		}
	}
}