package com.example.dao;

import com.example.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    void addUser(User user);

    List<User> findAll();

    void deleteUser(int id);

    User findUserById(int id);

    void updateUser(User user);

    void deleteSelected(String[] ids);

    int getTotal(Map<String, String[]> map);

    List<User> findByPage(int start, int rows, Map<String, String[]> map);
}
