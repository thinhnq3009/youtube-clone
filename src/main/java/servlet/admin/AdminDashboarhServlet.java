package servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.VideoDao;
import dao.ViewDao;
import module.PageInfomation;

/**
 * Servlet implementation class AdminDashboarhServlet
 */
@WebServlet("/Admin/Home")
public class AdminDashboarhServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long viewCount = new ViewDao().getViewCountAgo(0);
		long videoCount = new VideoDao().getVideoCountAgo(0);
		long userCount = new UserDao().getUserCountAgo(0);
		
		request.setAttribute("viewCount", viewCount);
		request.setAttribute("videoCount", videoCount);
		request.setAttribute("userCount", userCount);

		request.setAttribute("pageInfo", new PageInfomation("dashboarh", "Admin Dashboarh"));
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}

}
