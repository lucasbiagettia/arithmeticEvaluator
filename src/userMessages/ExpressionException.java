package userMessages;

public class ExpressionException extends UnsupportedOperationException {

	/**
	 * This exception is thrown when you try to make an Unsupported arithmetic or boolean operation
	 */
	private static final long serialVersionUID = 1L;

	
	public ExpressionException(String exception) {
		super(exception);
	}

}
