package servlet.account.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.UserDao;
import entity.User;
import handler.ApiPrinter;
import handler.Encoder;
import module.PageInfomation;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Encoder.setUTF8(request, response);

		request.setAttribute("pageInfo", new PageInfomation("signup", "Sign Up"));
		request.getRequestDispatcher("user.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Encoder.setUTF8(request, response);

		try {

			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			
			try {
				dao.insert(user);
				request.getSession().setAttribute("message", "Đăng ký thành công");
				response.sendRedirect("SignIn");
			} catch (Exception e) {
				e.printStackTrace();
				request.getSession().setAttribute("errorMessage", e.getMessage());
				response.sendRedirect("SignUp");
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
