package handler;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import entity.Video;

public class MessagePrinter {

	public static void checkSession(String name, HttpSession session, JspWriter out) {
		Object obj = session.getAttribute(name);
		try {
			out.print(obj != null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printSession(String name, HttpSession session, JspWriter out, boolean clear) {
		String message = (String) session.getAttribute(name);
		message = message == null ? "" : message;
		try {
			out.print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (clear) {
			session.removeAttribute(name);
		}
	}

	public static void printSession(String name, HttpSession session, JspWriter out) {
		printSession(name, session, out, true);
	}

	
	
}
