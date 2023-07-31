package servlet.account.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.manager.util.SessionUtils;
import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import entity.User;
import enums.AttributeName;
import handler.MailSender;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(AttributeName.PAGE_INFO, new PageInfomation("reset-password", "Reset Password"));
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		SessionManager sessionManger = new SessionManager(request);
		try {

			UserDao dao = new UserDao();

			User user = dao.findByUsername(username);

			if (user == null) {
				sessionManger.setErrorMessage("The username has not been registered yet.");
				doGet(request, response);
				return;
			} else {
				String token = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

				user.setResetPasswordToken(token);

				try {
					dao.update(user);
				} catch (Exception e) {
					sessionManger.setErrorMessage("Can't reset password now. Try later");
					doGet(request, response);
					return;
				}

				String link = getLinkResetPassword(request, token);
				
				MailSender.sendMailResetPassword(user, link);
				
				sessionManger.setMessage("Link reset password sent to '%s'. Please check your email.", user.getEmail());
				
				response.sendRedirect(request.getContextPath() + "/SignIn");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getLinkResetPassword(HttpServletRequest request, String token) {
		String url = request.getRequestURL().toString();
		String contextPath = request.getContextPath();
		int indexOf = url.indexOf(contextPath);
		String rootLink = url.substring(0, indexOf + contextPath.length());
		return String.format("%s/NewPassword?token=%s", rootLink, token);
	}

}
