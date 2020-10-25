package com.atguigu.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     * 获取指定名称的 Cookie 对象
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie findCookie(Cookie[] cookies,String name) {
        if (cookies == null || cookies.length == 0 || name == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
