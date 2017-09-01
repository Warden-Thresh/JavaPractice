package com.warden.practice.jdbc;

import com.warden.practice.charactor.Hero;

import java.util.List;

/**
 * Created by Warden on 2017/9/1.
 */
public interface DAO {
    public void add(Hero hero);

    public void update(Hero hero);

    public void delete(int id);

    public Hero get(int id);

    public List<Hero> list();

    public List<Hero> list(int start, int count);
}
