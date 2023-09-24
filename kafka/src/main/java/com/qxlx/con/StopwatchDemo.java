package com.qxlx.con;

import org.springframework.util.StopWatch;

/**
 * @author qxlx
 * @date 2023/9/5 10:24 PM
 */
public class StopwatchDemo {

    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start("任务A耗时");
//
//        Thread.sleep(10000);
//        stopWatch.stop();
//
//        System.out.println(stopWatch.prettyPrint());
//       new Thread (->(){
//
//        })
        StopWatchUtils.start("执行A方法");
        Thread.sleep(10000);
        StopWatchUtils.stop();

//        StopWatchUtils.print();

        run();
    }


    public static void run () throws InterruptedException {
        StopWatchUtils.start("执行B方法");
        Thread.sleep(10000);
        StopWatchUtils.stop();
    }


}
