package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Liked;
import entity.User;
import entity.Video;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class LikedServlet
 */
@WebServlet("/Liked")
public class LikedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManager = new SessionManager(request);

		User user = sessionManager.getUserLogin();

		List<Video> videos = user.getLikes().stream().filter(Liked::getIsLike).map(Liked::getVideo).distinct().toList();

		request.setAttribute("videos", videos);

		new PageInfomation("liked", "Video đã like").forward(request, response, "/user.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
