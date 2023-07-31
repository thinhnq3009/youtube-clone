package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Permission;
import exception.PermissionException;
import handler.PermissionManager;

/**
 * Servlet Filter implementation class RequiredAdminFilter
 */
@WebFilter(urlPatterns = { "/UsersManagement", "/Admin/Video/Edit", "/VideosManagement", "/Admin/Home" })
public class RequiredAdminFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Yêu cầu đã được kiểm tra qua filter: " + getClass());

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		try {
			PermissionManager.checkRequeste(servletRequest, Permission.ADMIN_ONLY);
			chain.doFilter(request, response);
		} catch (PermissionException e) {
			e.printStackTrace();
			System.out.println("Chuyển hướng do không có quyền truy cập");
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/Home");
		}
	}

}
