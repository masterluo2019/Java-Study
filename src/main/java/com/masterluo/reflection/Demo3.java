package com.masterluo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射创建对象，并操作对象
 * (1)clazz.newInstance() 需要类具有无参构造器
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<Student> clazz1 = Student.class;

//        Student student1 = clazz1.newInstance();

        // 通过构造器创建对象
//        Constructor<Student> constructor = clazz1.getDeclaredConstructor(String.class, String.class);
//        Student student = constructor.newInstance("luowei", "20");
//        System.out.println(student);

        // 通过反射调用普通方法
        Student stu = clazz1.newInstance();
        Method setAge = clazz1.getDeclaredMethod("setAge", String.class);
        setAge.invoke(stu, "20");
        System.out.println(stu.getAge());


        // 通过反射操作属性
        Field age = clazz1.getDeclaredField("age");
        age.setAccessible(true); // 默认为false， 反射不能直接访问私有属性或方法
        age.set(stu,"30");
        System.out.println(stu.getAge());
    }

}
