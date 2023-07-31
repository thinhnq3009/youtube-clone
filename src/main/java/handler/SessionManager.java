package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;
import enums.Permission;
import exception.PermissionException;

import static enums.AttributeName.*;

public class SessionManager {
	HttpServletRequest request;

	public SessionManager(HttpServletRequest request) {
		this.request = request;
	}

	private HttpSession getSession() {
		return request.getSession();
	}

	public void setErrorMessage(String value) {
		getSession().setAttribute(ERROR_MESSAGE, value);
	}

	public void setMessage(String value) {
		getSession().setAttribute(MESSAGE, value);
	}

	public void setMessage(String value, String... strings) {
		getSession().setAttribute(MESSAGE, String.format(value, strings));
	}

	public void set(String name, Object value) {
		getSession().setAttribute(name, value);
	}

	public void remove(String name) {
		getSession().removeAttribute(name);
	}

	public static void remove(HttpSession session, String name) {
		session.removeAttribute(name);
	}

	public static void removeMessage(HttpSession session) {
		remove(session, MESSAGE);
	}

	public static void removeErrorMessage(HttpSession session) {
		remove(session, ERROR_MESSAGE);
	}

	public User getUserLogin() {
		return (User) getSession().getAttribute(USER_LOGIN);
	}
	
	public void checkPermission(Permission permission) throws PermissionException{
		PermissionManager.checkRequeste(request, permission);
	}
}
