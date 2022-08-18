package program;

import expression_manager.Expression;
import user_messages.ExpressionException;
/**
 * 
 * Sample of use
 * @author LucasBiagetti
 *
 */
public class Program {

	public static void main(String[] args) {
		String string = "-3 / 6 /1770 + 1813 + manuelBelgrano -  1420 * 20 - 6 -  1820 ";
		System.out.println(string);
		try{Expression expression = new Expression(string);
		Double result = expression.getFinalValue();
		System.out.println("The result is "+ result);
		}catch (ExpressionException e) {
			e.printMessage();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
