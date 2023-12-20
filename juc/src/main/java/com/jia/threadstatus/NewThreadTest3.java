package com.jia.threadstatus;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/19 10:08 PM
 */
public class NewThreadTest3 {

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
            wait();
            System.out.println(Thread.currentThread().getName() + " 执行中");
        }

        synchronized void doNotify() throws InterruptedException {
            notify();
            System.out.println(Thread.currentThread().getName() + " 执行中");
        }

        synchronized void donotifyAll() throws InterruptedException {
            notifyAll();
            System.out.println(Thread.currentThread().getName() + " 执行中");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTask threadTask = new ThreadTask();
        Thread t1 = new Thread(threadTask);
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t1.getName() + "  stateName :" + t1.getState());
//        threadTask.doNotify();
        threadTask.donotifyAll();
        System.out.println(t1.getName() + "  stateName :" + t1.getState());
    }

}
