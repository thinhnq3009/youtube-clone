package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();

		Integer userOnlineCounter = (Integer) context.getAttribute("userOnlineCounter");

		userOnlineCounter = userOnlineCounter == null ? 1 : userOnlineCounter + 1;

		context.setAttribute("userOnlineCounter", userOnlineCounter);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();

		Integer userOnlineCounter = (Integer) context.getAttribute("userOnlineCounter");

		userOnlineCounter = userOnlineCounter == null ? 0 : userOnlineCounter - 1;

		context.setAttribute("userOnlineCounter", userOnlineCounter);
	}

}
