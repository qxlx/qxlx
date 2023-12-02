package com.jia.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("我是要执行的任务，正在处理中");
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Runnable runnable2 = new MyRunnable();

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(runnable);
        threadPool.execute(runnable2);

        try {
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}