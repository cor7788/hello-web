package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 首先检查验证码
        HttpSession session = req.getSession();
        String cc = (String) session.getAttribute("checkCode");

        if (cc.equalsIgnoreCase(checkCode)) {
            // 检查用户名和密码是否正确，如果都正确，重定向到登录成功界面
            if ("root".equals(username) && "12345".equals(password)) {
                req.setAttribute("username", username);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                req.setAttribute("error", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            // 验证码不正确，转发到登陆页面
            req.setAttribute("ccerror", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
