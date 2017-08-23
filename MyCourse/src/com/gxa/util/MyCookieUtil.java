package com.gxa.util;

import javax.servlet.http.Cookie;

public class MyCookieUtil {
/**
 * 
 * 用于判断cookie是否存在
 * @param cookie
 * @param name
 * @return
 */
	public static Cookie getCookieByName(Cookie[] cookie, String name) {
		if (cookie == null) {
			return null;
		} else {
			for (Cookie cookie2 : cookie) {
				if (cookie2.getName().equals(name)) {
					return cookie2;
				} else {
					return null;
				}
			}
		}
			return null;
	}
}
