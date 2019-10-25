package com.example;

import com.example.domain.User;
import com.example.util.JdbcUtilV1;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {

    private JdbcTemplate jt = new JdbcTemplate(JdbcUtilV1.getDataSource());

    @Test
    public void testInsert() {
        String sql = "insert into user(username, gender) values(?,?)";
        jt.update(sql, "jack", 1);
    }

    @Test
    public void testQueryForMap() {
        Map<String, Object> map = jt.queryForMap("select * from user where id = ?", "2");
        System.out.println(map);
    }

    @Test
    public void testQueryForList() {
        List<Map<String, Object>> list = jt.queryForList("select * from user");
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void testQuery() {
        String sql = "select * from user where id = ?";
        List<User> list = jt.query(sql, new BeanPropertyRowMapper<>(User.class), 1);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryForObject() {
        Long total = jt.queryForObject("select count(id) from user", Long.class);
        System.out.println(total);
    }

    @Test
    public void testQueryForObject2() {
        User user = jt.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }
}
