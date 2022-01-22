package com.masterluo.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 * Created by masterLuo
 * On 2022/1/22
 */
public class demo2 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                try {
                    ticket.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                try {
                    ticket.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                try {
                    ticket.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}

// 资源类 OOP
class Ticket {
    private int number = 20;

    // 创建锁对象
    Lock lock = new ReentrantLock();

    public void sale() throws InterruptedException {
        lock.lock(); // 加锁

        try {
            Thread.sleep(1000);
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number --) + "票,剩余：" + number);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();// 解锁
        }
    }
}
