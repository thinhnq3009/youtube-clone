package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import entity.Video;
import enums.AttributeName;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionManager sessionManger = new SessionManager(request);
		
		try {
			VideoDao dao = new VideoDao();
			
			List<Video> videos = dao.getAll();
			
			Collections.shuffle(videos);
			
			request.setAttribute(AttributeName.LIST_VIDEO , videos);
			
			new PageInfomation("home", "Trang chủ").forward(request, response, "/user.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
