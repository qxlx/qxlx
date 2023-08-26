package com.jia.future;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * @author jiabaobao
 * @date 2023/8/13 4:45 PM
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 异步调用三方");
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply(f -> {
            return f + 10;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果为:" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName()+" 异步调用三方A");
//                Thread.sleep(TimeUnit.SECONDS.toSeconds(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName()+" 异步调用三方B");
//                Thread.sleep(TimeUnit.SECONDS.toSeconds(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        System.out.println("开始调用");
        System.out.println(completableFuture.get());
        System.out.println("调用结束");
    }

}
