package com.masterluo.reflection;

/**
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过类名，获取该类的calss对象
        Class<Student> clazz1 = Student.class;

        // 通过类的全路径名，获取该类的calss对象
        Class clazz2 = Class.forName("com.masterluo.reflection.Student");

        // 通过类的普通对象，获取该类的calss对象
        Student student = new Student("aa", "1");
        Class clazz3 = student.getClass();

        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());
        System.out.println(clazz3.hashCode());

    }

}
