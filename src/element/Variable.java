package element;

import java.util.Scanner;

import expression_manager.Expression;
import user_messages.UserMessages;

public class Variable implements IElement{
	private final static Integer PRIORITY = 0;
	private String variable;
	
	public Variable (String theVariable) {
		variable = theVariable;
	}
	
	@Override
	public TypeOfElement getTypeOfElement() {
		return TypeOfElement.VARIABLE;
	}

	@Override
	public Integer getPriority() {
		return PRIORITY;
	}

	@Override
	public double solve(Double leftNode, Double rightNode) {
		try(Scanner scanner = new Scanner(System.in);){
			System.out.println(UserMessages.askForVariableValue()+ variable);
			String newStringExpression = scanner.nextLine();
			Expression newExpression =  new Expression (newStringExpression);
			return newExpression.getFinalValue();
		}
	}
}
