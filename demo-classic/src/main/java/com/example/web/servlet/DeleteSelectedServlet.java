package com.example.web.servlet;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelected")
public class DeleteSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] ids = req.getParameterValues("ids");
        if (ids != null && ids.length > 0) {
            UserService userService = new UserServiceImpl();
            userService.deleteSelected(ids);
        }
        resp.sendRedirect(req.getContextPath() + "/findPage");
    }
}
