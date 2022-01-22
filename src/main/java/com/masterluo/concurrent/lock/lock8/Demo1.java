package com.masterluo.concurrent.lock.lock8;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 修饰普通方法时，锁的对象是方法的调用者
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo1 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        //锁的存在
        new Thread(()->{
            phone.sendSms();
        },"A").start();
        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone1{
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
