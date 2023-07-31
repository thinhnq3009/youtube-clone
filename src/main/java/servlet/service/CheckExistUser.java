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
 * Servlet implementation class CheckExistUser
 */
@WebServlet("/CheckUsername")
public class CheckExistUser extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> message = new HashMap<>();

		String username = request.getParameter("username");

		if (username == null) {
			message.put("error", "Parammeter is null");
		} else if (username.isBlank()) {
			message.put("error", "Parammeter is empty");
		} else {

			UserDao dao = new UserDao();
			User user = dao.findByUsername(username);

			if (user == null) {
				message.put("message", String.format("Username '%s' not yet used", username));
				message.put("value", "false");
			} else {
				message.put("message", String.format("Username '%s' has been used", username));
				message.put("value", "true");
			}
		}

		try {
			ApiPrinter.print(message, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi hiển thị dữ liệu");
		}

	}

}
