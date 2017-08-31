package com.warden.practice.charactor;

/**
 * Created by Warden on 2017/8/31.
 */
public class Hero {
    public String name ;
    public float hp;
    public float armor;
    public int damage;
    public int moveSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public synchronized void recover(){
        if (hp>=1000){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);this.notify();
    }

    public synchronized void hurt(){
        if (hp ==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        this.notify();
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }

    public void attackHero(Hero h) {
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
