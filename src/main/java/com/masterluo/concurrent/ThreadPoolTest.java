package com.masterluo.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 工作中的运用：（1）定时任务，去数据库查询当天的异常数据，并将异常数据量发邮件告警
 * 由于数据量比较大，可以采用多线程的方式处理
 *             （2）批量更新数据
 * Created by masterLuo
 * On 2022/1/22
 */

public class ThreadPoolTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // 查询数据库中的异常数据
        List<String> dataList = qryDataList();

        // 将查询出来的数据平均分成10组
        List<List<String>> partitionList = Lists.partition(dataList, 1000);

        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(partitionList.size());

        // 异常数据量
        AtomicInteger exceptionCount = new AtomicInteger();

        // 创建线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(30));
        for (int i = 0; i < partitionList.size() ; i++) {
            List<String> subList = partitionList.get(i);
            threadPoolExecutor.execute(() -> {
                try {
                    // 对数据进行多线程操作
                    handle(exceptionCount, subList);
                    System.out.println(Thread.currentThread().getName() + "," + exceptionCount);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 计数器减1
                    countDownLatch.countDown();
                }
            });
        }


        try {
            // 阻塞主线程,当countDownLatch减到0时放行，超时时间是5分钟
            countDownLatch.await(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            threadPoolExecutor.shutdown();
        }

        // 发送邮件告警
        System.out.println(exceptionCount.get());

        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "mS");

    }

    private static List<String> qryDataList() {
        List<String> list = new ArrayList<>();
        // 模拟数据库
        for (int i = 0; i < 10000; i++) {
            list.add(UUID.randomUUID().toString().substring(0,5));
        }

        return list;
    }

    private static void handle(AtomicInteger exceptionCount, List<String> subList) {
        // 模拟异常
        for (String data : subList) {
            if (data.contains("a")) {
                exceptionCount.incrementAndGet();
            }
        }
    }
}
