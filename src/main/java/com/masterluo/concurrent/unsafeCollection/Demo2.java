package com.masterluo.concurrent.unsafeCollection;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 安全的hashMap
 * Created by masterLuo
 * On 2022/1/22
 */
public class Demo2 {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 10; i++) {
            // 开启10个线程，去添加数据到集合
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + "---" + map);
            }, String.valueOf(i)).start();

        }


    }
}
