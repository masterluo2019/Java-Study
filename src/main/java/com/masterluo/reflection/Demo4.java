package com.masterluo.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 * 很多框架底层都会用到
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo4 {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<Dog> clazz = Dog.class;

        // 获取Dog类的注解（不包括字段、方法上的注解）
        Annotation[] annotations = clazz.getAnnotations();

        // 获取@TableDog对应的表名
        TableDog tableDog = clazz.getDeclaredAnnotation(TableDog.class);
        System.out.println(tableDog.value());

        // 获取字段名
        Field age = clazz.getDeclaredField("age");
        TableField annotation = age.getAnnotation(TableField.class);
        System.out.println(annotation.columnName());
    }
}
