package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import exception.ApiPrinterException;

public class ApiPrinter {

	public static void print(String json, HttpServletRequest request, HttpServletResponse response) throws ApiPrinterException  {
		request.setAttribute("content", json);
		try {
			request.getRequestDispatcher("api.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ApiPrinterException();
		}

	}

	public static void print(Object obj, HttpServletRequest request, HttpServletResponse response) throws ApiPrinterException  {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		print(json, request, response);
	}

}
