package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import enums.AttributeName;
import exception.PageNotFoundException;
import exception.RequiedLoginException;
import handler.Encoder;
import handler.SessionManager;
import module.PageInfomation;

/**
 * Servlet Filter implementation class UpdateUserLogin
 */
@WebFilter({"/*"})
public class GlobalFilter extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		SessionManager sessionManger = new SessionManager(servletRequest);
		
		Encoder.setUTF8(servletRequest, servletResponse);
		
		// Cập nhật user sau mỗi request
		User users = sessionManger.getUserLogin();
		
		if (users != null) {
			users = new UserDao().findById(users.getId());
			sessionManger.set(AttributeName.USER_LOGIN, users);
		}
		
		// Khối bắt ngoại lệ được ném ra ở tất cả các servlet
		try {
			chain.doFilter(servletRequest, servletResponse);
		} catch (PageNotFoundException e) {
			System.out.println("Đã xử lý lỗi 404 từ servlet");
			servletRequest.setAttribute("message404", e.getMessage());
			new PageInfomation("404-page").forward(servletRequest, servletResponse, "/user.jsp");
		} catch (RequiedLoginException e) {
			System.out.println("Đã xử lý lỗi bắt buộc đăng nhập từ servlet");
			sessionManger.setErrorMessage(e.getMessage());
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/SignIn");
		}
		
	}



}
