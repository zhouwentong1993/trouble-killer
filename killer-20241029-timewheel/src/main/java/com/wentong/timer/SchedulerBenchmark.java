package com.wentong.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.TimerTask;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SchedulerBenchmark {

    private ScheduledExecutorService scheduledExecutorService;
    private HashedWheelTimer hashedWheelTimer;

    @Setup
    public void setup() {
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        hashedWheelTimer = new HashedWheelTimer();
    }

    @TearDown
    public void tearDown() {
        scheduledExecutorService.shutdown();
        hashedWheelTimer.stop();
    }

//    @Benchmark
//    public void testScheduledExecutorService() throws InterruptedException {
//        scheduledExecutorService.schedule(() -> {
//            // 模拟任务执行
//        }, 1, TimeUnit.MILLISECONDS);
//        Thread.sleep(1); // 确保任务有时间执行
//    }

    @Benchmark
    public void testHashedWheelTimer() throws InterruptedException {
        TimerTask timerTask = timeout -> {
            // 模拟任务执行
        };
        hashedWheelTimer.newTimeout(timerTask, 1, TimeUnit.MILLISECONDS);
        Thread.sleep(1); // 确保任务有时间执行
    }

    public static void main(String[] args) throws Exception {
        TimeUnit.SECONDS.sleep(20);
        System.out.println("start!!!" +
                "");
        org.openjdk.jmh.runner.Runner runner = new org.openjdk.jmh.runner.Runner(new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include(SchedulerBenchmark.class.getSimpleName())
                .forks(1) // 进程数
                .build());
        runner.run();
    }
}
