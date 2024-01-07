package com.jia.syn;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/1/2 10:08 PM
 */
public class SynTest {

    private Integer tickets = 0;

    public void sell() {
        tickets++;
    }

    public void sell2() {
        tickets--;
    }


    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synTest.sell();
            }
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synTest.sell2();
            }
        });

        thread1.start();
        thread.start();

        thread.join();
        thread1.join();


        TimeUnit.SECONDS.sleep(3);
        System.out.println("总共卖出多少票" + synTest.tickets);
    }

}
