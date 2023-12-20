package com.jia.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiabaobao
 * @date 2023/12/17 2:56 PM
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+ " 线程执行了");
        },"t1");

        Thread t2 = new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+ " 线程执行了");
        },"t2");

        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 线程执行了");
        },"t3");

        Thread t4 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 线程执行了");
        },"t4");

        t3.start();
        t4.start();
    }

}
