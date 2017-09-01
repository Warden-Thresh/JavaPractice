package com.warden.practice.jdbc;

import com.warden.practice.charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Warden on 2017/9/1.
 */
public class HeroDao implements DAO{
    public HeroDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                "admin");
    }
    public int getTotal(){
        int total = 0;
        try(Connection c = getConnection();
            Statement s = c.createStatement()){
            String sql = "SELECT COUNT (*) FROM hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("Total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    @Override
    public void add(Hero hero) {
        String sql="insert INTO hero VALUES (NULL ,?,?,?)";
        try(Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Hero hero) {
        String sql = "UPDATE hero SET name=?,hp=?,damage=? WHERE id=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try(Connection c = getConnection(); Statement s = c.createStatement()) {
            String sql = "DELETE FROM hero WHERE id ="+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Hero get(int id) {
        Hero hero = null;
        try (Connection c = getConnection();Statement s =c.createStatement()){
            String sql = "SELECT *FROM hero WHERE id =" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp =hp;
                hero.damage= damage;
                hero.id=id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<>();
        String sql = "SELECT * FROM hero ORDER BY id DESC limit ?,?";
        try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int damage = rs.getInt(4);
                hero.id= id;
                hero.name = name;
                hero.hp =hp;
                hero.damage = damage;
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }
}
