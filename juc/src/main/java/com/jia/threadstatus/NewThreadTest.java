package com.jia.threadstatus;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/19 10:08 PM
 */
public class NewThreadTest {

    public static class ThreadTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行前");
            System.out.println(Thread.currentThread().getName() + " 执行后");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadTask());
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t1.getName() + "  stateName :" + t1.getState());
    }

}
