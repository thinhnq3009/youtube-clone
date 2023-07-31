package exception;

import javax.servlet.ServletException;

public class RequiedLoginException extends ServletException {

	public RequiedLoginException() {
		super();
	}

	public RequiedLoginException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public RequiedLoginException(String message) {
		super(message);
	}

	public RequiedLoginException(Throwable rootCause) {
		super(rootCause);
	}
	
}
