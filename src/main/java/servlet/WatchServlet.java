package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import dao.ViewDao;
import entity.Comment;
import entity.User;
import entity.Video;
import enums.AttributeName;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class WatchServlet
 */
@WebServlet("/Watch")
public class WatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("v");
		SessionManager sessionManger = new SessionManager(request);
		User user = sessionManger.getUserLogin();
		try {
			VideoDao videDao = new VideoDao();
			ViewDao viewDao = new ViewDao();

			Video video = videDao.findByCode(code);

			if (video != null) {
				viewDao.watch(video, user);

				request.setAttribute(AttributeName.WATCHING_VIDEO, video);

				List<Video> videos = videDao.getAll();
				List<Comment> comments = video.getComments().stream()
						.sorted((c2, c1) -> c1.getTime().compareTo(c2.getTime()))
						.collect(Collectors.toList());

				request.setAttribute(AttributeName.LIST_VIDEO, videos);
				request.setAttribute("commentInVideo", comments);

				new PageInfomation("watch").forward(request, response, "/user.jsp");
			} else {
				new PageInfomation("404-error").forward(request, response, "/user.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
