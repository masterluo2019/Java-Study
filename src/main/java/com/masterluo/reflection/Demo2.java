package com.masterluo.reflection;

/**
 * 类的主动使用
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 创建类的实例
        Student person = new Student("a", "");

        // 访问类的静态成员和静态方法（除了常量）
//        Student.study();

        // 反射
//        Class<?> aClass = Class.forName("com.masterluo.reflection.Student");
        // 这种不会导致类初始化
//        Class<Student> studentClass = Student.class;

        // 初始化一个类的子类

    }
}
