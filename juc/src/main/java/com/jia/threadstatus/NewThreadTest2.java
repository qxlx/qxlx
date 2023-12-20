package com.jia.threadstatus;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/19 10:08 PM
 */
public class NewThreadTest2 {

    private Object o = new Object();

    public static class ThreadTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行前");
            try {
                doExec();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行后");
        }

        synchronized void doExec() throws InterruptedException {
            TimeUnit.SECONDS.sleep(10);
            System.out.println(Thread.currentThread().getName() + " 执行中");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTask threadTask = new ThreadTask();
        Thread t1 = new Thread(threadTask);
        t1.start();
        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(threadTask);
        t2.start();

        System.out.println(t1.getName() + "  stateName :" + t1.getState());
        System.out.println(t2.getName() + "  stateName :" + t2.getState());
    }

}
