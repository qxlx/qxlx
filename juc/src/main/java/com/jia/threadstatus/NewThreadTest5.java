package com.jia.threadstatus;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jiabaobao
 * @date 2023/12/19 10:08 PM
 */
public class NewThreadTest5 {

    public static class ThreadTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行前");
            try {
                Thread.sleep(10000);
                wait(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行后");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTask threadTask = new ThreadTask();
        Thread t1 = new Thread(threadTask);
        t1.start();
        t1.start();
       // TimeUnit.SECONDS.sleep(3);
        //System.out.println(t1.getName() + "  stateName :" + t1.getState());
    }

}
