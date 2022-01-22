package com.masterluo.concurrent.lock;

/** lock
 * Created by masterLuo
 * On 2022/1/22
 */
public class demo1 {

    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类, 把资源类丢入线程
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
class Ticket1 {
    // 属性、方法
    private int number = 20;

    // 卖票的方式
    // synchronized 本质: 队列，锁
    public synchronized void sale() throws InterruptedException {
        Thread.sleep(1000);
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + (number --) + "票,剩余：" + number);
        }
    }
}
