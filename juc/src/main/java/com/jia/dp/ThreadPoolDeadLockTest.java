package com.jia.dp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qxlx
 * @date 2024/1/1 11:17 AM
 */
public class ThreadPoolDeadLockTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        CountDownLatch l1 = new CountDownLatch(2);

        System.out.println("l1-begin");
        // 大任务l1 2个
        for (int i = 0; i < 2; i++) {
            threadPool.execute(()-> {
                CountDownLatch l2 = new CountDownLatch(2);
                System.out.println("l2-begin");
                //小任务l2 2个
                for (int j = 0; j < 2; j++) {
                    threadPool.execute(()->{
                        l2.countDown();
                    });
                }
                try {
                    l2.await();
                    l1.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("l2-end");
            });
        }
        System.out.println("l1-end");

        l1.await();
    }

}
