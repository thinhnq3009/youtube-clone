package servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import dao.VideoDao;
import entity.User;
import entity.Video;
import enums.Permission;
import exception.DaoException;
import exception.PageNotFoundException;
import exception.PermissionException;
import handler.FileHandler;
import handler.Originator;
import handler.PermissionManager;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet implementation class EditVideoServlet
 */
@WebServlet({ "/Channel/Video/Edit", "/Admin/Video/Edit" })
@MultipartConfig
public class UpdateVideoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManager = new SessionManager(request);
		User user = sessionManager.getUserLogin();
		String code = request.getParameter("code");

		if (code == null) {
			throw new PageNotFoundException();
		}

		try {

			VideoDao dao = new VideoDao();

			Video video = dao.findByCode(code);

			if (video == null) {
				throw new PageNotFoundException("Không tìm thấy video có code là <%s>".formatted(code));
			} else {

				PermissionManager.checkOwnerVideo(user, video, true);

				request.setAttribute("video", video);

				new PageInfomation("update-video").forward(request, response, "/user.jsp");

			}

		} catch (PermissionException e) {
			throw new PageNotFoundException("Bạn không có quyền để chỉnh sửa video này.");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("videoCode");

		if (code == null) {
			throw new PageNotFoundException();
		}

		try {
			VideoDao videoDao = new VideoDao();

			Video video = videoDao.findByCode(code);

			BeanUtils.populate(video, req.getParameterMap());

			try {
				String posterUrl = FileHandler.fileProcess(req, "poster", video.getCode(),
						"poster" + Originator.randomString(3));
				video.setPoster(posterUrl);
				System.out.println("Đã update Poster mới");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Không nhận được poster mới. Giữ poster cũ");
			}

			videoDao.update(video);

			resp.sendRedirect(req.getContextPath() + "/VideosManagement");

		} catch (DaoException e) {
			e.printStackTrace();
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
