package com.jia.threadpool;

import java.util.concurrent.*;

/**
 * @author jiabaobao
 * @date 2023/12/4 9:49 PM
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> resultCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1 + 1;
            }
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Integer> resultTask = threadPool.submit(resultCallable);
        System.out.println(resultTask.get());
        threadPool.shutdown();
    }

}
