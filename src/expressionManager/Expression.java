package expressionManager;

import java.util.ArrayList;

import binaryTree.BinaryTree;
import element.Operand;
import element.arithmeticOperators.AdditionOperator;
import element.arithmeticOperators.DivisionOperator;
import element.arithmeticOperators.MultiplicationOperator;
import element.arithmeticOperators.SubstractionOperator;
import userMessages.ExpressionException;

public class Expression {

	BinaryTree binaryTreeExpression = new BinaryTree();
	private StandarizedExpression standarizedExpression;
	private ArrayList<Operator> avaibleOperators = new ArrayList<Operator>();
	private static String listOfReservedSymbols = ".";
	private double finalValue;
	private boolean isThereAComparisonSign = false;
	private boolean isTheEqCorrect;



	public Expression(String expressionText) throws ExpressionException {
		standarizedExpression = new StandarizedExpression(expressionText);	
		
		addArithmeticOperators();
		expressionText = standarizeExpression(expressionText);
		validateExpression(expressionText);
		addElementsToBinaryTree(expressionText);

	}
	
	public double getFinalValue() {
		return finalValue;
	}


	private Expression(String expressionText, boolean ignoreValidation) throws ExpressionException {
		addArithmeticOperators();
		addElementsToBinaryTree(expressionText);
		finalValue = binaryTreeExpression.inOrderResult();
	}

	private void addArithmeticOperators() throws ExpressionException {
		listOfReservedSymbols += AdditionOperator.getInstance().getSymbol();
		listOfReservedSymbols += SubstractionOperator.getInstance().getSymbol();
		listOfReservedSymbols += DivisionOperator.getInstance().getSymbol();
		listOfReservedSymbols += MultiplicationOperator.getInstance().getSymbol();
		
	}

	private void addElementsToBinaryTree (String expressionText) throws ExpressionException {
		for (int i = 0; i <expressionText.lenght(); i++){
			if (expressionText.charAt(i) == '(' {
				String aux = "";
				
				while ( i < expressionText.length()-1 && expressionText.charAt(i) != ')'){
					i++;
					if (expressionText.charAt(i) != ')'){
						aux = aux + expressionText.charAt(i);
					}
				}
				Expression subExpression = new Expression (aux, true);
				double auxD = subExpression.getFinalValue89;
				binariTreeExpression = binaryTreeExpression.add(new Operand(auxD));
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
			else if (listOfReservedSymbos.indexOf(expressionText.charAt(i)) != -1){
				for (int j = 0; j < avaibleOperators.size(); j++){
					if (expressionText.charAt(i) == avcaibleOperators.get(j).getSymbol()){
						binaryTreeEpression = binaryTreeExpression.add(avaibleOperators.get(j9);
					}
				}
			}
		}
	}

	
}