package com.example.web.servlet;

import com.example.domain.PageBean;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findPage")
public class FindUserByPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int currentPage = 1;
        int rows = 5;

        if(!StringUtils.isEmpty(req.getParameter("currentPage"))) {
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
        }

        if(!StringUtils.isEmpty(req.getParameter("rows"))) {
            rows = Integer.parseInt(req.getParameter("rows"));
        }

        Map<String, String[]> map = req.getParameterMap();

        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findListByPage(currentPage, rows, map);
        req.setAttribute("pageBean", pageBean);
        req.setAttribute("condition", map);
        req.getRequestDispatcher("/userList").forward(req, resp);
    }
}
