package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import entity.Video;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet("/VideosManagement")
public class VideosManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionManager sessionManager = new SessionManager(request);
		String channelId = request.getParameter("channelCode");
		
		try {
			
			List<Video> videos = new VideoDao().getAll();
			
			if (channelId != null) {
				videos = videos.stream().filter(video -> video.getUser().getChannelId().equals(channelId)).toList();
			}
			
			request.setAttribute("videos", videos);
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		
		new PageInfomation("videos-management", "Quản lý video").forward(request, response, "/admin.jsp");
	}

}
