package com.jia.support;

import java.util.concurrent.locks.LockSupport;

/**
 * @author jiabaobao
 * @date 2023/9/23 4:42 PM
 */
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"线程执行");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"线程完毕");
        });
        thread.start();

        Thread.sleep(1000);
        LockSupport.unpark(thread);
    }



}
