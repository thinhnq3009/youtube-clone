package servlet.account.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import exception.ApiPrinterException;
import exception.DaoException;
import handler.ApiPrinter;

/**
 * Servlet implementation class ToggleBlockUserServlet
 */
@WebServlet("/ToggleBlockUser")
public class ToggleBlockUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String channelId = request.getParameter("channelId");

		Map<String, Object> map = new HashMap<>();

		try {

			UserDao dao = new UserDao();

			User user = dao.findByChannelId(channelId);

			if (user == null) {
				map.put("error", "Không tìm thấy User với id là <%s>".formatted(channelId));
			} else {
				boolean isActive = !user.getIsActive();
				user.setIsActive(isActive);

				dao.update(user);

				map.put("message",
						"Đã %skhoá tài khoảng cho %s".formatted(isActive ? "mở " : "", user.getChannelName()));
				map.put("isActive", isActive);
			}

		} catch (DaoException e) {
			e.printStackTrace();
			map.put("error", e.getMessage());
		} finally {
			try {
				ApiPrinter.print(map, request, response);
			} catch (ApiPrinterException e2) {
				// TODO: handle exception
			}
		}

	}

}
