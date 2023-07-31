package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import entity.Video;
import module.PageInfomation;

/**
 * Servlet implementation class TrendingServlet 
 */
@WebServlet("/Trending")
public class TrendingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Video> videos = new VideoDao().getTrendingVideo();
		
		
		request.setAttribute("videos", videos);
		
		new PageInfomation("trending", "Top thịnh hành").forward(request, response, "/user.jsp");

	}

}
