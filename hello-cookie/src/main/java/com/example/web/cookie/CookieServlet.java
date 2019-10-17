package com.example.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/a")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", URLEncoder.encode("你好", "UTF-8"));
//        Cookie cookie1 = new Cookie("data", URLEncoder.encode("我是root", "utf-8"));
        resp.addCookie(cookie);
//        resp.addCookie(cookie1);
    }
}
