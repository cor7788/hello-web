package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.PageBean;
import com.example.domain.User;
import com.example.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteSelected(String[] ids) {
        userDao.deleteSelected(ids);
    }

    @Override
    public PageBean<User> findListByPage(int currentPage, int rows, Map<String, String[]> map) {
        PageBean<User> pageBean = new PageBean<>();

        // 1.获取总条数；
        int totalCount = userDao.getTotal(map);
        pageBean.setTotalCount(totalCount);
        // 2.计算总页数
        int totalPage = (int) Math.ceil(1.0 * totalCount / rows);
        pageBean.setTotalPage(totalPage);
        // 3.设置当前页数
        pageBean.setCurrentPage(currentPage);
        // 判断页码是否越界
        if(currentPage <= 0) {
            currentPage = 1;
        } else if(currentPage > totalPage) {
            currentPage = totalPage;
        }
        // 4.根据开始索引和条数查询数据
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findByPage(start, rows, map);
        pageBean.setList(list);
        return pageBean;
    }
}
