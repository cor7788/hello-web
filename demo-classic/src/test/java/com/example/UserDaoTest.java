package com.example;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.PageBean;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();
    private UserService userService = new UserServiceImpl();

    @Test
    public void testMath() {
        double ceil = Math.ceil(1.0 * 100 / 6);
        System.out.println(ceil);
    }

}
