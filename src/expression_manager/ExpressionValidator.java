package expression_manager;

import user_messages.ExceptionMessages;
import user_messages.ExpressionException;

public class ExpressionValidator {

	static void validateExpression(String expressionText, String listOfReservedSymbols) throws ExpressionException {

		int parenthesiCounter = 0;
		for (int i = 0; i < expressionText.length(); i++) {
			if (Character.isLetterOrDigit(expressionText.charAt(i)) == false
					&& (listOfReservedSymbols + "()").indexOf(expressionText.charAt(i)) == -1) {
				throw new ExpressionException(ExceptionMessages.syntaxError());
			}
			if (expressionText.charAt(i) == '(') {
				parenthesiCounter++;
			}
			if (expressionText.charAt(i) == ')') {
				parenthesiCounter--;
			}
		}

		if (parenthesiCounter != 0) {
			throw new ExpressionException(ExceptionMessages.parenthesiError());
		}
	}
}
