package poly.com.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	public Cookie create(String name, String value, int days) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days * 60 * 60*24);
		cookie.setPath("/");
		return cookie;
	}

	public Cookie get(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equalsIgnoreCase(name))
					return cookie;
		return null;
	}
}