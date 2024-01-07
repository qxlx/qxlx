package com.jia.suspension;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2023/12/30 3:13 PM
 */
public class SynTest {

    private Object obj;

    public Object read() {
        synchronized (this) {
            while (Objects.isNull(obj)) {
                try {
                    System.out.println(Thread.currentThread().getName()+  " wait-before");
                    this.wait();
                    System.out.println(Thread.currentThread().getName()+  " wait-after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }
    }

    public void write() {
        System.out.println(Thread.currentThread().getName()+ "  write");
        synchronized (this) {
            obj = new Object();
            System.out.println(Thread.currentThread().getName()+ "  notifyAll-before");
            this.notifyAll();
            System.out.println(Thread.currentThread().getName()+ "   notifyAll-after");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();

        new Thread(()-> {
            synTest.read();
        }).start();

        new Thread(()-> {
            synTest.write();
        }).start();

        TimeUnit.SECONDS.sleep(2);
    }

}
