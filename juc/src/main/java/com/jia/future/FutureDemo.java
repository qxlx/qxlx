package com.jia.future;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author jiabaobao
 * @date 2023/8/13 4:15 PM
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.sleep(10000);
            System.out.println("调用三方翻译接口");
            return 1024;
        });

        new Thread(futureTask).start();

        Integer integer = futureTask.get();
//        Integer integer = futureTask.get(1, TimeUnit.SECONDS);

        while (true) {
            if (futureTask.isDone()) {
                System.out.println("完成任务");
                break;
            } else {
                System.out.println("执行中，稍等.");
            }
        }
        Integer x = futureTask.get();
        System.out.println(x);
    }

}
