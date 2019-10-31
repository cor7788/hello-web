package com.example.web.servlet;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 1.获取验证码
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");

        // 2.比较验证码
        if(code != null && code.equalsIgnoreCase(checkCode)) {
            // 3.比较用户名和密码
            if("root".equals(username) && "123456".equals(password)) {
                resp.sendRedirect(req.getContextPath() + "/findPage");
            } else {
                req.setAttribute("err", "用户名或密码错误");
                req.getRequestDispatcher("/").forward(req, resp);
            }
        } else {
            req.setAttribute("err", "验证码错误");
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
