package com.wentong.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestTimer {

    public static void main(String[] args) throws Exception {
        // 创建一个调度线程池
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 1000000; i++) {

            // 创建一个定时任务
            Runnable task = () -> {
                System.out.println("执行定时任务: " + System.currentTimeMillis());
            };

            // 提交任务，初始延迟 0 秒，每 5 秒执行一次
            scheduler.scheduleAtFixedRate(task, 1000, 1000, TimeUnit.SECONDS);

        }
        System.out.println("任务提交完成");

        // 运行一段时间后关闭调度器
        try {
            Thread.sleep(30000); // 运行 30 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduler.shutdown();
        }
        Thread.currentThread().join();

    }

}
