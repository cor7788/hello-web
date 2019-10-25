package com.example;

import com.example.util.JdbcUtilV1;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
    public static void main(String[] args) {
        JdbcTemplateDemo demo = new JdbcTemplateDemo();
        demo.testUpdate();
    }

    private void testUpdate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtilV1.getDataSource());
        jdbcTemplate.update("update user set gender = ? where id = ?", 0, 3);
    }
}
