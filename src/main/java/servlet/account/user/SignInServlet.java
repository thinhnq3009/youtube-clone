package servlet.account.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import entity.User;
import enums.AttributeName;
import handler.CookieManager;
import handler.Encoder;
import module.PageInfomation;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Encoder.setUTF8(request, response);
		
		CookieManager cookieManager = new CookieManager(request, response);
		
		String accessToken = cookieManager.getCookieValue(AttributeName.REMEMBER_ME);
		if (accessToken != null) {
			
			User user = new UserDao().findByAcceptToken(accessToken);
			if (user != null) {
				request.getSession().setAttribute(AttributeName.USER_LOGIN, user);
				
			}
			
		}
		

		request.setAttribute(AttributeName.PAGE_INFO, new PageInfomation("signin", "Đăng nhập"));
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String remember = request.getParameter("remember");

		HttpSession session = request.getSession();

		try {

			UserDao dao = new UserDao();

			User user = dao.checkLogin(username, password);

			session.setAttribute(AttributeName.USER_LOGIN, user);
			session.setAttribute(AttributeName.MESSAGE, "Login successfull");

			doRemember(request, response, user, remember);

			response.sendRedirect(request.getContextPath() + "/Home");

		} catch (Exception e) {
			session.setAttribute(AttributeName.ERROR_MESSAGE, e.getMessage());
			request.setAttribute(AttributeName.PAGE_INFO, new PageInfomation("signin", "Đăng nhập"));
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}

	}

	private void doRemember(HttpServletRequest request, HttpServletResponse response, User user, String remember) {
		try {
			if (remember != null) {
				
				
				CookieManager cm = new CookieManager(request, response);
				
				String accessToken = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
				
				// Save accessToken in database
				user.setAcceptToken(accessToken);
				UserDao dao = new UserDao();
				dao.update(user); //throw e
				
				cm.addCookie("remember", accessToken);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Không update được uesr");
		}

	}

}
