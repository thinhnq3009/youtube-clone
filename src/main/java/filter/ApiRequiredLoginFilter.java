package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import exception.ApiPrinterException;
import exception.PermissionException;
import handler.ApiPrinter;
import handler.PermissionManager;

/**
 * Servlet Filter implementation class RequiredLoginFilter
 */
@WebFilter(urlPatterns = { "/Subscribe", "/Comment", "/Like" })
public class ApiRequiredLoginFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Yêu cầu đã được kiểm tra qua filter");

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		try {
			PermissionManager.checkRequeste(servletRequest, Permission.REQUIRED_LOGIN);
			chain.doFilter(request, response);
		} catch (PermissionException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			
			map.put("error", "Yêu cầu cần đăng nhập");
			map.put("statusCode", 403);
			
			try {
				ApiPrinter.print(map, servletRequest, servletResponse);
			} catch (ApiPrinterException e1) {
				e1.printStackTrace();
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/404-page");
			}
			
		}

	}

}
