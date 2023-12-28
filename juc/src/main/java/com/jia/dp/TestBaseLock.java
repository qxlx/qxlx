package com.jia.dp;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/24 5:32 PM
 */
public class TestBaseLock {

    private Integer lockA = new Integer(0);
    private Integer lockB = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
        TestBaseLock t = new TestBaseLock();
        new Thread(()-> { t.lockA();}).start();
        new Thread(()-> { t.lockB();}).start();


        TimeUnit.SECONDS.sleep(100);
    }

    public void lockA () {
        synchronized (lockA) {
            System.out.println("LockA before");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("LockA after");
        }
    }

    public void lockB ()  {
        synchronized (lockA) {
            System.out.println("LockB before");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("LockB after");
        }
    }
}
