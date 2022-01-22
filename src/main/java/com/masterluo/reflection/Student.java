package com.masterluo.reflection;

/**
 * Created by masterLuo
 * On 2022/1/22
 */
public class Student extends Person {

    private String id;
    private String name;
    private String age;

    public Student() {
    }

    static {
        System.out.println("Student 类初始化中。。。。。");
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
        System.out.println("Student 执行构造器");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void study(){
        System.out.println("study....");
    }
}
