package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.util.JdbcUtilV1;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jc = new JdbcTemplate(JdbcUtilV1.getDataSource());

    @Override
    public void addUser(User user) {
        String sql = "insert into user(username, birthday, gender, address) values(?,?,?,?)";
        jc.update(sql, user.getUsername(), user.getBirthday(), user.getGender(), user.getAddress());
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jc.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        jc.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        return jc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set username = ?, password = ?, birthday = ?, gender = ?, address = ? where id = ?";
        jc.update(sql, user.getUsername(), user.getPassword(), user.getBirthday(), user.getGender(), user.getAddress(), user.getId());
    }

    @Override
    public void deleteSelected(String[] ids) {
        for (String id : ids) {
            int uid = Integer.parseInt(id);
            deleteUser(uid);
        }
    }

    @Override
    public int getTotal(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select count(id) from user where 1=1 ");

        Set<String> keys = map.keySet();
        ArrayList<String> params = new ArrayList<>();
        for(String key: keys) {
            if(key.equals("currentPage") || key.equals("rows")) continue;
            if(!StringUtils.isEmpty(map.get(key)[0])) {
                params.add("%" + map.get(key)[0] + "%");
                sql.append(" and ").append(key).append(" like ?");
            }
        }
        Integer total = jc.queryForObject(sql.toString(), Integer.class, params.toArray());
        if (total == null) {
            return 0;
        } else {
            return total;
        }
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder("select * from user where 1=1 ");

        Set<String> keys = map.keySet();
        ArrayList<Object> params = new ArrayList<>();
        for(String key: keys) {
            if(key.equals("currentPage") || key.equals("rows")) continue;
            if(!StringUtils.isEmpty(map.get(key)[0])) {
                params.add("%" + map.get(key)[0] + "%");
                sb.append(" and ").append(key).append(" like ?");
            }
        }
        params.add(start);
        params.add(rows);

        sb.append("limit ?,?");
        return jc.query(sb.toString(), new BeanPropertyRowMapper<>(User.class), params.toArray());
    }

}
