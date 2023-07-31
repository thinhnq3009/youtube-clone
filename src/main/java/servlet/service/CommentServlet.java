package servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CommentDao;
import dao.VideoDao;
import entity.Comment;
import entity.Video;
import handler.ApiPrinter;
import handler.SessionManager;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManager = new SessionManager(request);
		String commentContent = request.getParameter("content");
		String videoId = request.getParameter("videoId");

		
		try {
			Video video = new VideoDao().findByCode(videoId);
			
			Comment comment = new Comment();
			comment.setContent(commentContent);
			comment.setUser(sessionManager.getUserLogin());
			comment.setVideo(video);
			
			CommentDao dao = new CommentDao();

			dao.insert(comment);

			request.setAttribute("comment", comment);
			
			request.getRequestDispatcher("/components/api/comment-item.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
