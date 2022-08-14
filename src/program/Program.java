package program;

import expressionManager.Expression;

public class Program {

	public static void main(String[] args) {
		String string = "12 * 9 + 17  - 2 ";
		System.out.println(string);
		Expression expression = new Expression(string);
		Double result = expression.getFinalValue();
		System.out.println("The result is "+ result);

	}

}
