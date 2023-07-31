package servlet.account.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDao;
import entity.User;
import exception.DaoException;
import handler.ApiPrinter;
import handler.Encoder;
import handler.FileHandler;
import handler.Originator;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/MyProfile")
@MultipartConfig
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Encoder.setUTF8(request, response);
		new PageInfomation("my-profile").forward(request, response, "/user.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionManager sessionManger = new SessionManager(request);
		Encoder.setUTF8(request, response);
		
		User user = sessionManger.getUserLogin();

		try {

			BeanUtils.populate(user, request.getParameterMap());
			
//				String channelName = request.getParameter("channelName");
//				String channelId = request.getParameter("channelId");
//				String email = request.getParameter("email");
//				String story = request.getParameter("story");

			try {
				String newAvatar = FileHandler.fileProcess(request, "avatar", "/avatars", Originator.randomString(20));
				user.setAvatar(newAvatar);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
//			user.setChannelName(channelName);
//			user.setChannelId(channelId);
//			user.setEmail(email);
//			user.setStory(story);
//			

			UserDao dao = new UserDao();
			
			dao.update(user);

			

		} catch (DaoException e) {
			System.out.println(e.getLocalizedMessage());
			sessionManger.setErrorMessage("Channel id đã được sử dụng.");
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			doGet(request, response);
		}

	}

}
