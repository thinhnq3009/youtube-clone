package handler;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encoder {
	public static void setUTF8(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
	}

	public static void setUTF8(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	}

	public static void setUTF8(HttpServletRequest request,HttpServletResponse response ) throws UnsupportedEncodingException {
		setUTF8(request);
		setUTF8(response);
	}
	
	
	
}
