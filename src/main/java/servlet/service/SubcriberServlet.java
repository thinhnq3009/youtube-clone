package servlet.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.SubscriptionDao;
import dao.UserDao;
import entity.Subscription;
import entity.User;
import exception.ApiPrinterException;
import exception.DaoException;
import handler.ApiPrinter;
import handler.SessionManager;

/**
 * Servlet implementation class SubcriberServlet
 */
@WebServlet("/Subscribe")
public class SubcriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Subscription sub = new Subscription();

		SessionManager sessionManger = new SessionManager(request);

		String channelId = request.getParameter("channelId");

		System.out.println(channelId);

		Map<String, Object> map = new HashMap<>();

		try {

			UserDao dao = new UserDao();

			User channel = dao.findByChannelId(channelId);

			User user = sessionManger.getUserLogin();

			sub.setSubscriber(user);
			sub.setChannel(channel);

			SubscriptionDao subDao = new SubscriptionDao();
			boolean value = subDao.toggleSubscribe(sub);

			map.put("value", value);
			map.put("message",
					String.format("%s đã%s đăng ký thành công cho %s", user.getChannelName(),value ? "" : " huỷ" , channel.getChannelName()));

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("error", "Không đăng ký được");
			
		} finally {
			try {
				ApiPrinter.print(map, request, response);
			} catch (ApiPrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
