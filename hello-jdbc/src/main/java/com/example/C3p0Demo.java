package com.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from user where  id = ?");
        stmt.setInt(1, 2);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            System.out.println(id + "--" + username);
        }
    }
}
