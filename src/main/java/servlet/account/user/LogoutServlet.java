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
import handler.CookieManager;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CookieManager cookieManager = new CookieManager(request, response);

		cookieManager.removeCookie(AttributeName.REMEMBER_ME);
		User user = (User) request.getSession().getAttribute(AttributeName.USER_LOGIN);
		user.setAcceptToken(null);
		try {
			new UserDao().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Đăng xuất nhưng không xoá acceptToken");
		}
		
		request.getSession().removeAttribute(AttributeName.USER_LOGIN);

		response.sendRedirect(request.getContextPath() + "/SignIn");
	}
}
