package com.jia.threadstatus;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jiabaobao
 * @date 2023/12/19 10:08 PM
 */
public class NewThreadTest4 {

    public static class ThreadTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行前");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 执行后");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTask threadTask = new ThreadTask();
        Thread t1 = new Thread(threadTask);
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(t1.getName() + "  stateName :" + t1.getState());
        LockSupport.unpark(t1);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(t1.getName() + "  stateName :" + t1.getState());
    }

}
