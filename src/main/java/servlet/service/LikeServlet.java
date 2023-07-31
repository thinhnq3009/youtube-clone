package servlet.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LikeDao;
import dao.VideoDao;
import entity.Liked;
import entity.User;
import entity.Video;
import exception.ApiPrinterException;
import exception.DaoException;
import handler.ApiPrinter;
import handler.SessionManager;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/Like")
public class LikeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String videoCode = req.getParameter("videoCode");
		String isLikeString = req.getParameter("isLike");
		boolean isLike = false;
		try {
			isLike = Boolean.parseBoolean(isLikeString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		SessionManager sessionManager = new SessionManager(req);

		Map<String, Object> map = new HashMap<>();
		String message = "";

		try {

			Video video = new VideoDao().findByCode(videoCode);

			User user = sessionManager.getUserLogin();

			LikeDao dao = new LikeDao();

			Liked like = dao.handelLike(user, video, isLike);

			if (like == null) {
				message = String.format("%s đã huỷ %slike video <%s>", user.getChannelName(), isLike ? "" : "dis",
						video.getTitle());
			} else {
				if (like.getIsLike()) {
					message = String.format("%s đã like video <%s>", user.getChannelName(), video.getTitle());
				} else {
					message = String.format("%s đã dislike video <%s>", user.getChannelName(), video.getTitle());
				}
			}

			map.put("message", message);
			map.put("isLike", isLike);
			map.put("isRemove", like == null);
			
			ApiPrinter.print(map, req, resp);

		} catch (DaoException e) {
			e.printStackTrace();
		} catch (ApiPrinterException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
