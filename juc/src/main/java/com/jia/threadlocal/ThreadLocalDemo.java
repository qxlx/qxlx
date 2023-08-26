package com.jia.threadlocal;

/**
 * @author jiabaobao
 * @date 2022/6/6 10:30 PM
 */
public class ThreadLocalDemo {

    //每个线程都有一份自己的变量存储起来
    ThreadLocal threadLocal = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {
//        ThreadA threadA = new ThreadA();
//        Thread thread = new Thread(threadA);
//        thread.start();
//
//        ThreadA threadB = new ThreadA();
//        Thread threadBB = new Thread(threadB);
//        threadBB.start();

        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        new Thread(()-> {

            try {
                threadLocalDemo.threadLocal.set(100);
                for (int i = 0; i < 100; i++) {
                    threadLocalDemo.sellTickets();
                }
                System.out.println(Thread.currentThread());
                System.out.println(Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //防止内存移除
                threadLocalDemo.threadLocal.remove();
            }

        }).start();

        System.out.println();
        

    }

    public  void sellTickets () {
        Integer o = (Integer)threadLocal.get();
        if (o > 0) {
            System.out.println(Thread.currentThread().getName() + "销售了一张票" + ": " + --o);
            threadLocal.set(o);
        } else {
            System.out.println("票卖完了");
        }
    }

}

class ThreadA implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tickets tickets = new Tickets();
            tickets.sellTickets();
        }
    }
}

class Tickets {

    private static int number = 100;

    public synchronized void sellTickets () {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "销售了一张票" + ": " + --number);
        } else {
            System.out.println("票卖完了");
        }
    }
}