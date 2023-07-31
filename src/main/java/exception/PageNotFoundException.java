package exception;

import javax.servlet.ServletException;

public class PageNotFoundException extends ServletException {

	public PageNotFoundException() {
		super();
	}

	public PageNotFoundException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public PageNotFoundException(String message) {
		super(message);
	}

	public PageNotFoundException(Throwable rootCause) {
		super(rootCause);
	}



}
