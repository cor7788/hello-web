package com.example.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/b")
public class CookieServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cks = req.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                System.out.println(ck.getName() + ":" + URLDecoder.decode(ck.getValue(), "UTF-8"));
            }
        }
    }
}
