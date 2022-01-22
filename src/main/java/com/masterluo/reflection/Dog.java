package com.masterluo.reflection;

/**
 * Created by masterLuo
 * On 2022/1/22
 */
@TableDog("DB_DOG")
public class Dog {
    @TableField(columnName = "ID", type = "char", length = 16)
    private String id;

    @TableField(columnName = "AGE", type = "char", length = 16)
    private String age;

    @TableField(columnName = "NAME", type = "int", length = 16)
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
    }


}
