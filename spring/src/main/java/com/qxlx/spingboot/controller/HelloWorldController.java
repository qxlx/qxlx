package com.qxlx.spingboot.controller;

import com.qxlx.spingboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jiabaobao
 * @date 2023/10/22 8:58 PM
 */
@RestController
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/hiii", method = RequestMethod.GET)
    public String hi() {
        //userService.saveUserDb();
        try {
            oom1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hi UserService";
    }

    private void oom1() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(() -> {
                String payload = IntStream.rangeClosed(1, 1000000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(payload);
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    private void printStats(ThreadPoolExecutor threadPool) {

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {

            logger.info("=========================");
            logger.info("Pool Size: {}", threadPool.getPoolSize());
            logger.info("Active Threads: {}", threadPool.getActiveCount());
            logger.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            logger.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            logger.info("=========================");

        }, 0, 1, TimeUnit.SECONDS);

    }

}
