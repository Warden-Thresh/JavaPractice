package com.warden.practice.jdbc;

import com.warden.practice.charactor.Hero;

import java.util.List;

/**
 * Created by Warden on 2017/9/1.
 */
public class TestDAO {
    public static void main(String[] args) {
        HeroDao dao = new HeroDao();
        List<Hero> list = dao.list();
        System.out.println("数据库中一共有" + list.size() + "条数据");
        Hero ahri = new Hero();
        System.out.println("新加一条数据");
        ahri.name = "九尾妖狐";
        ahri.hp = 666.0f;
        ahri.damage = 50;
        dao.add(ahri);
        list  =dao.list();
        System.out.println("数据库中总共有"+list.size()+"条数据");
        System.out.println("取出id=111的数据它的name是：");
        Hero hero = new Hero();
        hero = dao.get(112);
        System.out.println(hero.name);
        System.out.println("把名字改为 提莫，并且更新到数据库");
        hero.name = "提莫";
        dao.update(hero);
        System.out.println("取出id=111的数据它的name是：");
        hero = dao.get(112);
        System.out.println(hero.name);
        System.out.println("删除id=111的数据");
        dao.delete(112);
        list = dao.list();
        System.out.println("数据库中总共有"+list.size()+"条数据");
    }
}
