package com.jia.suspension;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qxlx
 * @date 2023/12/30 3:38 PM
 */
public class LockSupportTest {

    private Object obj;

    public Object read() {
        while (obj == null) {
            System.out.println("read-线程等待");
            LockSupport.park();
            System.out.println("read-线程唤醒");
        }
        return obj;
    }

    public void write(Thread thread) {
        obj = new Object();
        LockSupport.unpark(thread);
        System.out.println("唤醒线程");
    }

    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest();

        Thread thread = new Thread(() -> {
            lockSupportTest.read();
        });

        thread.start();

        Thread thread2 = new Thread(() -> {
            lockSupportTest.write(thread);
        });

        thread2.start();
    }

}
