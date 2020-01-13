package com.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class CookieUtils {
    public static String getLogin(HttpServletRequest request) {
        Cookie login = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("login")).findFirst().orElse(null);
        if (login == null) {
            return null;
        }
        return login.getValue();
    }

    public static String getRedirect(HttpServletRequest request){
        Cookie redirect = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("redirect")).findFirst().orElse(null);
        if (redirect == null) {
            return "/";
        }
        return redirect.getValue();
    }

    public static void setLogin(HttpServletResponse response, String value){
        Cookie cookie = new Cookie("login", value);
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    public static void setPassword(HttpServletResponse response, String password){
        Cookie cookie = new Cookie("password", password);
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    public static void setRedirect(HttpServletResponse response, String redirect){
        Cookie cookie = new Cookie("redirect", redirect);
        response.addCookie(cookie);
    }
}
