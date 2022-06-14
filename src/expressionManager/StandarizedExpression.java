package expressionManager;

import userMessages.ExceptionMessages;
import userMessages.ExpressionException;

public class StandarizedExpression {
	String standarizedExpression;

	public StandarizedExpression(String expressionText) throws ExpressionException {
		standarizedExpression = standarizeExpression(expressionText);
	}
	
	public String getStandarizedExpression() {
		return standarizedExpression;
	}
	
	private String standarizeExpression(String expressionText) throws ExpressionException {
		expressionText = replaceSignsAndSpaces(expressionText);
		if (!isValidSingleCharacterExpression(expressionText)) {
			throw new ExpressionException(ExceptionMessages.syntaxError());
		}

		expressionText = deleteFirstAndLastEqual(expressionText);
		expressionText = addMultiplicationOperatorWhenIsNeccesary(expressionText);

		return expressionText;
	}

	private String replaceSignsAndSpaces(String expressionText) {
		expressionText = expressionText.replace(" ", "");
		expressionText = expressionText.replace(",", ".");
		expressionText = expressionText.replace(")", "]");
		expressionText = expressionText.replace("(", "[");
		return expressionText;
	}

	private Boolean isValidSingleCharacterExpression(String expressionText) {
		return (expressionText.length() == 1 && Character.isLetterOrDigit(expressionText.charAt(0)));

	}

	private String deleteFirstAndLastEqual(String expressionText) {
		// TODO ver que pasa si hay 3 iguales.

		if (expressionText.charAt(0) == '=') {
			expressionText = expressionText.substring(1);
		}
		if (expressionText.charAt(expressionText.length() - 1) == '=') {
			expressionText = expressionText.substring(0, expressionText.length() - 1);
		}
		return expressionText;
	}

	private String addMultiplicationOperatorWhenIsNeccesary(String expressionText) {
		for (int i = 1; i < expressionText.length(); i++) {
			if (expressionText.charAt(i) == '(' && Character.isLetterOrDigit(expressionText.charAt(i - 1))) {
				expressionText = expressionText.substring(0, i) + "*" + expressionText.substring(i);
				i++;
			}
		}
		for (int i = 0; i < expressionText.length() - 1; i++) {
			if (expressionText.charAt(i) == ')' && Character.isLetterOrDigit(expressionText.charAt(i + 1))) {
				expressionText = expressionText.substring(0, i) + "*" + expressionText.substring(i + 1);
				i++;
			}
		}
		for (int i = 1; i < expressionText.length(); i++) {
			if (Character.isLetter(expressionText.charAt(i))
					&& Character.isLetterOrDigit(expressionText.charAt(i - 1))) {
				expressionText = expressionText.substring(0, 1) + "*" + expressionText.substring(i);
				i++;
			}
		}
		for (int i = 0; i < expressionText.length(); i++) {
			if (Character.isLetter(expressionText.charAt(i))
					&& Character.isLetterOrDigit(expressionText.charAt(i - 1))) {
				expressionText = expressionText.substring(0, 1) + "*" + expressionText.substring(i);
				i++;
			}
		}
		return expressionText;
	}

}
