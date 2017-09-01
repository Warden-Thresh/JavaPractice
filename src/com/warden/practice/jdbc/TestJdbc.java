package com.warden.practice.jdbc;

import java.sql.*;

/**
 * Created by Warden on 2017/9/1.
 */
public class TestJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql = "INSERT INTO hero VALUES (null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             // 根据sql语句创建PreparedStatement
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1, "Ahri");
            ps.setFloat(2,313.0f);
            ps.setInt(3, 50);
            ps.execute();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

