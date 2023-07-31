package servlet.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class EmailContentServlet
 */
@WebServlet("/EmailContentProvider")
public class EmailContentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String link = request.getParameter("l");
		String id = request.getParameter("id");
		User user = null;
		try {
			user = new UserDao().findById(Long.parseLong(id));

			request.setAttribute("name", user.getChannelName());
			request.setAttribute("link", link);

			request.getRequestDispatcher("mail-content.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
