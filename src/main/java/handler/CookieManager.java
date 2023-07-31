package handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	HttpServletRequest request;
	HttpServletResponse response;

	public CookieManager(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60);
		this.response.addCookie(cookie);

	}

	public Cookie[] getCookies() {
		return request.getCookies();
	}

	public Cookie getCookie(String name) {
		for (Cookie cookie : getCookies()) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}

		return null;
	}

	public String getCookieValue(String name) {
		try {
			return getCookie(name).getValue();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public void removeCookie(String name) {
		Cookie cookie = getCookie(name);
		if (cookie == null) return;
		cookie.setMaxAge(0);
		
	}
}
