package com.jia.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiabaobao
 * @date 2023/11/22 10:17 PM
 */
public class TreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(15),
                new ThreadFactory() {
                    private final AtomicInteger atomicInteger = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "pool-" + atomicInteger.getAndIncrement());
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());

        //执行
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("qxlxi,currentName:"+Thread.currentThread().getName());
            }
        });

        //关闭
        pool.shutdown();
        boolean terminated = false;
        while (!terminated) {
            pool.awaitTermination(100,TimeUnit.SECONDS);
        }
        System.out.println("pool is shutdowm.");
    }

}
