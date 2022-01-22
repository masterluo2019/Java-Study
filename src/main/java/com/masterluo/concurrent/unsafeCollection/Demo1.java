package com.masterluo.concurrent.unsafeCollection;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.多线程操作list时，会产生ConcurrentModificationException
 *    解决方案：（1）用工具类转换成安全的集合
 *                  List<String> list = Collections.synchronizedList(new ArrayList<>());
 *            (2) CopyOnWriteArrayList 写入时复制，避免多线程时导致覆盖，底层采用的lock锁
 * 2.CopyOnWriteArrayList 和 Vector 的区别
 *     CopyOnWriteArrayList底层时lock锁，Vector是同步方法，前者的效率更高
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo1 {
    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            // 开启10个线程，去添加数据到集合
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + "---" + list);
            }, String.valueOf(i)).start();

        }
    }
}
