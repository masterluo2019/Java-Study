package com.masterluo.jvm;

/**
 * "a" "b" "ab"放在方法区中的运行时常量池中
 * s1 + s2 会new一个StringBuilder对象，是放在堆内存中的
 * Created by masterLuo
 * On 2022/2/17
 *
 *
 */
public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");
    }
}
