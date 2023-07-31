package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class UsersManagementServlet
 */
@WebServlet("/UsersManagement")
public class UsersManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManager = new SessionManager(request);

		try {

			UserDao dao = new UserDao();

			List<User> users = dao.getAll();

			request.setAttribute("users", users);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		new PageInfomation("user-management", "Quản lý người dùng").forward(request, response, "/admin.jsp");

	}

}
