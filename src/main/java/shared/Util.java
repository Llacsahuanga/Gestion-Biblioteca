package shared;

import javax.servlet.http.Cookie;

public class Util {
	
	public static String getCookieValue(Cookie[] cookies, String key) {
		String valueCookie = null;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(key)) {
				valueCookie = cookie.getValue();
				break;
			}
		}
		
		return valueCookie;
	}
}
