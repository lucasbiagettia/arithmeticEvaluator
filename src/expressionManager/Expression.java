package expressionManager;

import java.util.List;

import binaryTree.BinaryTree;
import element.AbstractOperator;
import element.Operand;
import element.arithmeticOperators.AdditionOperator;
import element.arithmeticOperators.DivisionOperator;
import element.arithmeticOperators.MultiplicationOperator;
import element.arithmeticOperators.SubstractionOperator;
import userMessages.ExpressionException;

public class Expression {

	BinaryTree binaryTreeExpression;
	private String listOfReservedSymbols = ".";
	private double finalValue;
	private List<AbstractOperator> avaibleOperators;
	


	public Expression(String expressionText) throws ExpressionException {
		addArithmeticOperators();
		
		
		expressionText = ExpressionStandarizer.standarizeExpression(expressionText);
		ExpressionValidator.validateExpression(expressionText, listOfReservedSymbols);
		addElementsToBinaryTree(expressionText);

	}
	
	private Expression (String expressionText, Boolean ignoreValidation) {
		if (ignoreValidation) {
			addArithmeticOperators();
			addElementsToBinaryTree(expressionText);
		}else {
			return;
		}
		
	}
	
	public double getFinalValue() {
		return finalValue;
	}

	private void addArithmeticOperators() throws ExpressionException {
		avaibleOperators.add(AdditionOperator.getInstance());
		avaibleOperators.add(SubstractionOperator.getInstance());
		avaibleOperators.add(DivisionOperator.getInstance());
		avaibleOperators.add(MultiplicationOperator.getInstance());
		
		listOfReservedSymbols += AdditionOperator.getInstance().getSymbol();
		listOfReservedSymbols += SubstractionOperator.getInstance().getSymbol();
		listOfReservedSymbols += DivisionOperator.getInstance().getSymbol();
		listOfReservedSymbols += MultiplicationOperator.getInstance().getSymbol();
		
	}

	// TODO esto se debería resolver con un parser
	private void addElementsToBinaryTree (String expressionText) throws ExpressionException {
		for (int i = 0; i <expressionText.length(); i++){
			if (expressionText.charAt(i) == '(') {
				String aux = "";
				
				while ( i < expressionText.length()-1 && expressionText.charAt(i) != ')'){
					i++;
					if (expressionText.charAt(i) != ')'){
						aux = aux + expressionText.charAt(i);
					}
				}
				Expression subExpression = new Expression (aux, true);
				Double auxResult = subExpression.getFinalValue();
				binaryTreeExpression = binaryTreeExpression.add(new Operand(auxResult));
			}
			else if (Character.isLetter(expressionText.charAt(i))) {
				String aux = "";
				while (i<expressionText.length() && Character.isLetter(expressionText.charAt(i))){
					aux = aux + expressionText.charAt(i);
					i++;
				}
				i--;
				double auxD = Double.parseDouble(aux);
				binaryTreeExpression = binaryTreeExpression.add(new Operand(auxD));
			}
			else if (listOfReservedSymbols.indexOf(expressionText.charAt(i)) != -1){
				for (int j = 0; j < listOfReservedSymbols.length(); j++){
					
					if (expressionText.charAt(i) == avaibleOperators.get(j).getSymbol()){
						binaryTreeExpression = binaryTreeExpression.add(avaibleOperators.get(j));
					}
					
				}
			}
		}
	}

	
}