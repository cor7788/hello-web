package com.example.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/path")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
        String b = servletContext.getRealPath("b.txt");
        System.out.println(b);
        String c = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);
    }
}
