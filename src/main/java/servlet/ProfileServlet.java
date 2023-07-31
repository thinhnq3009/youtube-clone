package servlet;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import module.PageInfomation;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet({ "/Channel/*" })
public class ProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String code = request.getPathInfo().substring(1);
			
			if (!code.startsWith("@")) {
				throw new EntityNotFoundException("Id không hợp lệ để tìm kiếm");
			}
			
			User users = new UserDao().findByChannelId(code.substring(1));
			
			if (users == null) {
				throw new EntityNotFoundException("Không tìm thấy user");
			}

			request.setAttribute("channel", users);

			new PageInfomation("profile").forward(request, response, "/user.jsp");

		} catch (EntityNotFoundException | NullPointerException e) {
			e.printStackTrace();
			new PageInfomation("404-error", "Không tìm thấy trang").forward(request, response, "/user.jsp");
		}

	}

}
