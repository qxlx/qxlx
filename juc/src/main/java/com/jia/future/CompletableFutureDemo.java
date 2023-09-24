package com.jia.future;

import org.omg.CORBA.TIMEOUT;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author jiabaobao
 * @date 2023/8/13 4:45 PM
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("开始调用三方");
        CompletableFuture<HashMap> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 异步调用三方");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap resultMap = new HashMap();
            resultMap.put("1","1");
            return resultMap;
//        }).thenApply(f -> {
//            return f + 10;
//        }).whenComplete((v, e) -> {
//            if (e == null) {
//                System.out.println("计算结果为:" + v);
//            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });


        CompletableFuture<HashMap> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 异步调用三方");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap resultMap = new HashMap();
            resultMap.put("2","2");
            return resultMap;
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        System.out.println("aaa");
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

        stopWatch.stop();
        Map<String,String> resultMap = new HashMap<>();
        stopWatch.start("任务1");
        System.out.println("开始调用1");
        System.out.println(completableFuture.get());
        resultMap.putAll(completableFuture.get());
        System.out.println("调用结束1");
        stopWatch.stop();

        stopWatch.start("任务2");
        System.out.println("开始调用2");
        System.out.println(completableFuture2.get());
        resultMap.putAll(completableFuture2.get());
        System.out.println("调用结束2");

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        System.out.println(resultMap);
    }

}
