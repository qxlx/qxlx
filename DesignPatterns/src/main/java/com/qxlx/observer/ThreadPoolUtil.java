package com.qxlx.observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qxlx
 * @date 2024/4/13 22:38
 */
public class ThreadPoolUtil {

    private static ExecutorService threadPool;

    public static ExecutorService getThreadPool(Integer thredNum) {
        created(thredNum);
        return threadPool;
    }

    private static void created(Integer threadNum) {
        if (threadPool == null) {
            synchronized (ThreadPoolUtil.class) {
                if (threadPool == null) {
                    threadPool = Executors.newFixedThreadPool(threadNum);
                }
            }
        }
    }

}
