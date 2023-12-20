package com.jia.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiabaobao
 * @date 2023/12/11 10:40 PM
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();


        Thread thread = new Thread(() -> {
            try {
                reentrantLock.lock();
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + " ..." + i);
//                }
                TimeUnit.MINUTES.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        thread.setName("main-1");
        thread.start();


        Thread thread2 = new Thread(() -> {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " ..." + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        thread2.setName("main-2");
        thread2.start();


    }

}
