package com.warden.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Warden on 2017/9/1.
 */
public class TestJdbc {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            Connection c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java",
                            "root", "admin");

            System.out.println("连接成功，获取连接对象： " + c);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

