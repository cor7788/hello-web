package com.example.web.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        // 获取get请求方式的参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 获取post请求方式的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry: parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            System.out.println(key + "=" + Arrays.toString(values));
        }
        // 另一种方式获取post请求方式的参数
        Enumeration<String> pNames = request.getParameterNames();
        while(pNames.hasMoreElements()){
            String key = pNames.nextElement();
            String value = request.getParameter(key);
            System.out.println(key + "=" + value);
        }

        // 判断用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("root".equals(username) && "123".equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功");
        } else {
            request.getRequestDispatcher("/login-fail").forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
