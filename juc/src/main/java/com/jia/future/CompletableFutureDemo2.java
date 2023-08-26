package com.jia.future;


/**
 * @author jiabaobao
 * @date 2023/8/13 6:20 PM
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) {
//        CompletableFuture<java.lang.String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            return "helloword";
//        }).thenApply(s -> s + "qq");
//
//        System.out.println(completableFuture.join());

        int x  = 10;
        int y = 20;
        if (x == 10) {
            System.out.println("dsadsa");
        } else if (y == 20) {
            System.out.println("abababba");
        }
    }

}
