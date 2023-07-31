package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import entity.Video;
import entity.View;
import enums.AttributeName;
import handler.SessionManager;
import module.PageInfomation;

@WebServlet({ "/History", "/WatchLater" })
public class HistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionManager sessionManger = new SessionManager(request);

		User user = sessionManger.getUserLogin();

		List<View> views = user.getViews();

		Collections.sort(views, (v2, v1) -> v1.getTime().compareTo(v2.getTime()));

		List<Video> videos = views.stream().map(View::getVideo).distinct().collect(Collectors.toList());

		request.setAttribute(AttributeName.LIST_VIDEO, videos);

		new PageInfomation("history", "Lịch sử").forward(request, response, "/user.jsp");
	}

}
