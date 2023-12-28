package com.jia.dp;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/23 11:01 PM
 */
public class StopThreadTest {

    private Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("before");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.stop();
    }

}
