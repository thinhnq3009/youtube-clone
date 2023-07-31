package servlet.account.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subscription;
import entity.User;
import exception.RequiedLoginException;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class SubscribedServlet
 */
@WebServlet("/Subcribed")
public class SubscribedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManager = new SessionManager(request);

		User user = sessionManager.getUserLogin();

		if (user == null) {
			throw new RequiedLoginException("Đăng nhập để sử dụng chức năng này");
		}

		List<User> channels = user.getListChannelSubcribed().stream().map(Subscription::getChannel)
				.sorted((c2, c1) -> c1.getVideos().size() - c2.getVideos().size()).toList();

		request.setAttribute("channels", channels);

		new PageInfomation("subscribed", "Kênh đã đăng ký").forward(request, response, "/user.jsp");
		;

	}
}
