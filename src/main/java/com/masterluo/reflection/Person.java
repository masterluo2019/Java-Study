package com.masterluo.reflection;

/**
 * Created by masterLuo
 * On 2022/1/22
 */
public class Person {

    int num = 500;

    static {
        System.out.println("Person 类初始化中。。。。。");
    }

    public Person() {
        System.out.println("Person 执行构造器");
    }
}
