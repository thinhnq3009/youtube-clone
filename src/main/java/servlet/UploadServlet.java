package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.VideoDao;
import entity.User;
import entity.Video;
import enums.Permission;
import exception.ApiPrinterException;
import exception.DaoException;
import exception.PermissionException;
import handler.ApiPrinter;
import handler.Encoder;
import handler.FileHandler;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/Upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Encoder.setUTF8(request, response);

		request.setAttribute("pageInfo", new PageInfomation("upload"));
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManger = new SessionManager(request);
		Video video = new Video();
		Encoder.setUTF8(request, response);
		try {

			// IllegalAccessException, InvocationTargetException
			BeanUtils.populate(video, request.getParameterMap());

			String videoSrc = FileHandler.fileProcess(request, "video", video.getCode(), "video");
			String posterSrc = FileHandler.fileProcess(request, "poster", video.getCode(), "poster");

			video.setPoster(posterSrc);
			video.setVideoUrl(videoSrc);
			video.setUser(sessionManger.getUserLogin());

			VideoDao dao = new VideoDao();

			dao.insert(video);

			sessionManger.setMessage("Video has been uploaded");

		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();

		} catch (DaoException e) {
			e.printStackTrace();
			sessionManger.setErrorMessage("Can't upload video. Try again!");
		} finally {
			response.sendRedirect(request.getContextPath() + "/Home");
		}

	}

}
