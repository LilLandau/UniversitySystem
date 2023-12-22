package Users;

public class NoAccessToCourseException extends Exception{
	public NoAccessToCourseException(String message) {
		super(message);
	}
}
