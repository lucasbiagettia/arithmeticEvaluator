package user_messages;

public class ExpressionException extends UnsupportedOperationException {

	/**
	 * This exception is thrown when you try to make an Unsupported arithmetic operation
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	
	public ExpressionException(String exceptionMessage) {
		super();
		message = exceptionMessage;
		
	}
	
	public void printMessage() {
		System.out.println(message);
	}
}
