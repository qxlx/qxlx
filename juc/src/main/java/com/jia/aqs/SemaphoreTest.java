package com.jia.aqs;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * @author jiabaobao
 * @date 2023/12/18 8:59 PM
 */
public class SemaphoreTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for ( ; ; ) {
            threadPool.execute(()-> exec());
        }
    }

    public static void exec() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " before");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("执行任务");
            System.out.println(Thread.currentThread().getName() + " after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
