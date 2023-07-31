package servlet.service;

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
import handler.ApiPrinter;

/**
 * Servlet implementation class VerifyUserServlet
 */
@WebServlet("/VerifyUser")
public class VerifyUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String channelId = req.getParameter("channelId");

			UserDao dao = new UserDao();
			User user = dao.findByChannelId(channelId);
			Map<String, Object> map = new HashMap<>();

			if (user != null) {
				boolean isVerify = !user.getIsVerified();
				user.setIsVerified(isVerify);
				
				// Lưu lại (throw DaoExeption)
				dao.update(user);
				
				String message = String.format("Đã %sxát thực cho (%s)", isVerify ? "" : "huỷ ", user.getChannelId());
				
				map.put("message", message);
				map.put("isVerify", isVerify);
				map.put("value", true);
				
				
			} else {
				map.put("message", "Không thể tìm thấy user có id là " + channelId);
				map.put("value", false);
			}

			ApiPrinter.print(map, req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
