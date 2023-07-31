package servlet.account.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import enums.AttributeName;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class NewPasswordServlet
 */
@WebServlet("/NewPassword")
public class NewPasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String token = req.getParameter("token");

		try {
			UserDao dao = new UserDao();

			User user = dao.findByResetPasswordToken(token);

			req.setAttribute("token", token);
			req.setAttribute("channelName", user.getChannelName());
			req.setAttribute(AttributeName.PAGE_INFO,
					new PageInfomation("new-password", "Create new password for " + user.getChannelName()));
			req.getRequestDispatcher("/user.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String token = req.getParameter("token");
			String password = req.getParameter("password");
			
			SessionManager sessionManger = new SessionManager(req);
			
			try {
				UserDao dao = new UserDao();
				
				User user = dao.findByResetPasswordToken(token);
				
				if (user != null ) {
					user.setPassword(password);
					user.hashPassword();
					user.setAcceptToken(null);
					dao.update(user);
					
					sessionManger.setMessage("Create new password successfull.");
					resp.sendRedirect(req.getContextPath() + "/SignIn");
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

}
