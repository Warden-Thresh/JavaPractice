package com.warden.practice.jdbc;

import com.warden.practice.charactor.Hero;

import java.sql.*;

/**
 * Created by Warden on 2017/9/1.
 */
public class OrmTest {
    public static Hero get(int id){
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
            Statement s = c.createStatement()){
            String sql = "SELECT * FROM  hero WHERE id = "+id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new Hero();
                hero.name = rs.getString(2);
                hero.hp = rs.getFloat("hp");
                hero.damage = rs.getInt(4);
                hero.id = id;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }
}
