package module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.AttributeName;

public class PageInfomation {
	
	String view;
	String titlePage;
	
	public PageInfomation(String view) {
		this.view = view;
		this.titlePage = "YouTube";
	}

	public PageInfomation(String view, String titlePage) {
		this.view = view;
		this.titlePage = titlePage;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}
	
	public void forward(HttpServletRequest request, HttpServletResponse response, String jspFile) throws ServletException, IOException {
		request.setAttribute(AttributeName.PAGE_INFO, this);
		request.getRequestDispatcher(jspFile).forward(request, response);
	}
	
	
}
