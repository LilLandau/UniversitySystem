package Users;

public class NoAccessToCourseException extends Exception{
	private static final long serialVersionUID = -3924443582199737556L;

	public NoAccessToCourseException(String message) {
		super(message);
	}
}
