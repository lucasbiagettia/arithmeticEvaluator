package expression_manager;

import element.arithmetic_operators.MultiplicationOperator;
import user_messages.ExceptionMessages;
import user_messages.ExpressionException;

public class ExpressionStandarizer {

	static String standarizeExpression(String expressionText) throws ExpressionException {
		expressionText = replaceSignsAndSpaces(expressionText);
		if (expressionText.length() == 0) {
			throw new ExpressionException(ExceptionMessages.invalidOperation());
		}
		if (!isValidSingleCharacterExpression(expressionText)) {
			throw new ExpressionException(ExceptionMessages.syntaxError());
		}

		expressionText = addMultiplicationOperatorWhenIsNeccesary(expressionText);

		return expressionText;
	}

	private static String replaceSignsAndSpaces(String expressionText) {
		expressionText = expressionText.replace(" ", "");
		expressionText = expressionText.replace(",", ".");
		expressionText = expressionText.replace(")", "]");
		expressionText = expressionText.replace("(", "[");
		return expressionText;
	}

	private static Boolean isValidSingleCharacterExpression(String expressionText) {
		if (expressionText.length() == 1) {
			return (Character.isLetterOrDigit(expressionText.charAt(0)));
		} else {
			return true;
		}
	}

	/**
	 * This method add the symbol "*" when it helps to solve the operation
	 * Example: * it replaces 4(9) with 4*(9)
	 * @param expressionText
	 * @return
	 */
	private static String addMultiplicationOperatorWhenIsNeccesary(String expressionText) {
		Character multiplicationSign = MultiplicationOperator.getInstance().getSymbol();
		for (int i = 1; i < expressionText.length(); i++) {
			if (expressionText.charAt(i) == '(' && Character.isLetterOrDigit(expressionText.charAt(i - 1))) {
				expressionText = expressionText.substring(0, i) + multiplicationSign + expressionText.substring(i);
				i++;
			}
		}
		for (int i = 0; i < expressionText.length() - 1; i++) {
			if (expressionText.charAt(i) == ')' && Character.isLetterOrDigit(expressionText.charAt(i + 1))) {
				expressionText = expressionText.substring(0, i) + multiplicationSign + expressionText.substring(i + 1);
				i++;
			}
		}

		for (int i = 1; i < expressionText.length(); i++) {
			if (Character.isDigit(expressionText.charAt(i)) && Character.isLetter(expressionText.charAt(i - 1))) {
				expressionText = expressionText.substring(0, i) + multiplicationSign + expressionText.substring(i);
				i++;
			}
		}
		return expressionText;
	}

}
