package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import entity.Video;
import handler.WordHandler;
import module.PageInfomation;

/**
 * Servlet implementation class QueryVideoServlet
 */
@WebServlet("/Result")
public class QueryVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String keyword = request.getParameter("search_query");

		List<String> keys = WordHandler.splitSentences(keyword);

		try {
			VideoDao dao = new VideoDao();

			List<Video> videos = dao.findByKeyWord(keys);

			List<Long> ids = new ArrayList();

			videos = videos.stream().filter(video -> {

				if (ids.isEmpty()) {
					ids.add(video.getId());
					return true;
				}
					

				for (Long id : ids) {
					if (id == video.getId()) {
						return false;
					}
				}

				ids.add(video.getId());
				return true;

			}).toList();

			request.setAttribute("keyword", keyword);
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new PageInfomation("query").forward(request, response, "/user.jsp");
		}

	}

}
