package program;

import expressionManager.Expression;
/**
 * 
 * Sample of use
 * @author LucasBiagetti
 *
 */
public class Program {

	public static void main(String[] args) {
		String string = "12*  9 + 1755  *43 / 1154 + Jorge -  2 /4/6/2*989-111+2312/2131  ";
		System.out.println(string);
		Expression expression = new Expression(string);
		Double result = expression.getFinalValue();
		System.out.println("The result is "+ result);
	}
}
