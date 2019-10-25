package com.example;

import com.example.util.JdbcUtil;
import com.example.util.JdbcUtilV1;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JdbcDemo demo = new JdbcDemo();
        demo.testUtil();
    }

    public void test() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/z_test", "root", "147258369");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select count(*) from user");
        stmt.close();
        conn.close();
    }

    private void testQuery() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/z_test", "root", "147258369");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            System.out.println(id + "--" + name);
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }

    private void testUtil() throws SQLException {
        Connection conn = JdbcUtilV1.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet resultSet = stmt.executeQuery("select * from user");
        PreparedStatement stmt = conn.prepareStatement("select * from user where id = ?");
        stmt.setInt(1, 1);
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            System.out.println(id + "--" + name);
        }
        JdbcUtil.close(resultSet, stmt, conn);
    }
}
