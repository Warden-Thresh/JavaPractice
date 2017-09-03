package com.warden.practice.test;

import com.warden.practice.hibernate_annotation.*;
import com.warden.practice.pojo.Hero;

import java.lang.reflect.Method;

public class ParseHibernateAnnotation {
    public static void main(String[] args) {
        Class<Hero> heroClass = Hero.class;
        MyEntity myEntity = (MyEntity) heroClass.getAnnotation(MyEntity.class);
        if (null == myEntity) {
            System.out.println("Hero类不是实体类");
        }else {
            System.out.println("Hero类是实体类");
            MyTable myTable = (MyTable) heroClass.getAnnotation(MyTable.class);
            String tableName = myTable.name();
            System.out.println("其对应的表名是：" + tableName);
            Method[] methods = heroClass.getMethods();
            Method primaryKeyMethod = null;
            for (Method m :
                    methods) {
                MyId myId = m.getAnnotation(MyId.class);
                if (null != myId) {
                    primaryKeyMethod = m;
                    break;
                }
            }
            if (null != primaryKeyMethod) {
                System.out.println("找到主键:" + primaryKeyMethod.getName());
                MyGeneratedValue myGeneratedValue = primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
                System.out.println("其自增长策略是：" + myGeneratedValue.strategy());
                MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
                System.out.println("对应数据库中的字段是：" + myColumn.value());
            }
            System.out.println("其他非主键属性分别对应的数据库字段如下");
            for (Method m :
                    methods) {
                if (m == primaryKeyMethod) {
                    continue;
                }
                MyColumn myColumn = m.getAnnotation(MyColumn.class);
                if (null == myColumn) {
                    continue;
                }
                System.out.format("属性： %s\t对应的数据库字段是：%s%n",method2attribute(m.getName()),myColumn.value());

            }
        }
    }

    private static String method2attribute(String methodName) {
        String result = methodName;
        result = result.replaceFirst("get", "");
        result = result.replaceFirst("is", "");
        if (result.length() <= 1) {
            return result.toLowerCase();
        }else {
            return result.substring(0, 1).toLowerCase()+result.substring(1,result.length());
        }
    }
}
