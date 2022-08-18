package expression_manager;

import java.util.ArrayList;
import java.util.List;

import binary_tree.BinaryTree;
import element.AbstractOperator;
import element.Operand;
import element.Variable;
import element.arithmetic_operators.AdditionOperator;
import element.arithmetic_operators.DivisionOperator;
import element.arithmetic_operators.MultiplicationOperator;
import element.arithmetic_operators.SubstractionOperator;
import user_messages.ExpressionException;

public class Expression {

	BinaryTree binaryTreeExpression = new BinaryTree();
	private String listOfReservedSymbols = ".";
	private double finalValue;
	private List<AbstractOperator> avaibleOperators;

	public Expression(String expressionText) throws ExpressionException {
		addArithmeticOperators();
		expressionText = ExpressionStandarizer.standarizeExpression(expressionText);
		ExpressionValidator.validateExpression(expressionText, listOfReservedSymbols);
		addElementsToBinaryTree(expressionText);
		finalValue = binaryTreeExpression.inOrderResult();

	}

	private Expression(String expressionText, Boolean ignoreValidation) {
		if (ignoreValidation) {
			addArithmeticOperators();
			addElementsToBinaryTree(expressionText);
		} else {
			return;
		}

	}

	public double getFinalValue() {
		return finalValue;
	}

	private void addArithmeticOperators() throws ExpressionException {
		avaibleOperators = new ArrayList<AbstractOperator>();
		avaibleOperators.add(AdditionOperator.getInstance());
		avaibleOperators.add(SubstractionOperator.getInstance());
		avaibleOperators.add(DivisionOperator.getInstance());
		avaibleOperators.add(MultiplicationOperator.getInstance());
		for (int i = 0; i < avaibleOperators.size(); i++) {
			listOfReservedSymbols += avaibleOperators.get(i).getSymbol();
		}
	}
	
	/**
	 * Parse the expresion to add elements to the binaryTree
	 * @param expressionText
	 * @throws ExpressionException
	 */
	private void addElementsToBinaryTree(String expressionText) throws ExpressionException {
		for (int i = 0; i < expressionText.length(); i++) {
			if (expressionText.charAt(i) == '(') {
				String aux = "";

				while (i < expressionText.length() - 1 && expressionText.charAt(i) != ')') {
					i++;
					if (expressionText.charAt(i) != ')') {
						aux = aux + expressionText.charAt(i);
					}
				}
				Expression subExpression = new Expression(aux, true);
				Double auxResult = subExpression.getFinalValue();
				binaryTreeExpression.add(new Operand(auxResult));
			} 
			else if (Character.isDigit(expressionText.charAt(i)) || expressionText.charAt(i) == '.') {
//				Integer dotCount = 0;
//				if ( expressionText.charAt(i) == '.') {
//					dotCount ++;
//					if (dotCount > 1) {
//						throw new ExpressionException(ExceptionMessages.syntaxError());
//					}
//				}
				String aux = "";
				while (i < expressionText.length() && Character.isDigit(expressionText.charAt(i))) {
					aux = aux + expressionText.charAt(i);
					i++;
				}
				i--;
				double auxD = Double.parseDouble(aux);
				binaryTreeExpression.add(new Operand(auxD));
			} else if (Character.isLetter(expressionText.charAt(i))) {
				String aux = "";
				while (i < expressionText.length() && Character.isLetter(expressionText.charAt(i))) {
					aux = aux + expressionText.charAt(i);
					i++;
				}
				i--;
				binaryTreeExpression.add(new Variable(aux));
			}
			else if (listOfReservedSymbols.indexOf(expressionText.charAt(i)) != -1) {
				for (int j = 0; j < avaibleOperators.size(); j++) {

					if (expressionText.charAt(i) == avaibleOperators.get(j).getSymbol()) {
						binaryTreeExpression.add(avaibleOperators.get(j));
					}
				}
			}
		}
	}
}