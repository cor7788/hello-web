package com.example.service;

import com.example.domain.PageBean;
import com.example.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    void addUser(User user);

    List<User> findAll();

    void deleteUser(int id);

    User findUserById(int id);

    void updateUser(User user);

    void deleteSelected(String[] ids);

    PageBean<User> findListByPage(int currentPage, int rows, Map<String, String[]> map);
}
