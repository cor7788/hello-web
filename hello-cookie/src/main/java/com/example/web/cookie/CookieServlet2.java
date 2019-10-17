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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/c")
public class CookieServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cks = req.getCookies();
        boolean haveIt = false;
        if (cks != null) {
            for (Cookie ck : cks) {
                String name = ck.getName();
                if ("lastTime".equals(name)) {
                    haveIt = true;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 hh:MM:ss");
                    String dateStr = simpleDateFormat.format(date);
                    String lastTime = URLDecoder.decode(ck.getValue(), "utf-8");
                    ck.setValue(URLEncoder.encode(dateStr, "utf-8"));
                    resp.addCookie(ck);
                    resp.getWriter().write("<h1>您上次访问的时间是: " + lastTime + "</h1>");
                    break;
                }
            }
        }

        if (cks == null || !haveIt) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 hh:MM:ss");
            String dateStr = simpleDateFormat.format(date);

            Cookie ck = new Cookie("lastTime", URLEncoder.encode(dateStr, "utf-8"));
            resp.addCookie(ck);
            resp.getWriter().write("<h1>你好，欢迎您首次访问</h1>");
        }
    }
}
