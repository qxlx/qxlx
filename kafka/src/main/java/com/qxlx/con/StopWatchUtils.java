package com.qxlx.con;

import org.springframework.util.StopWatch;

import java.util.Objects;
import java.util.StringJoiner;

public class StopWatchUtils {

    public static ThreadLocal<StopWatch> CURRENT_STOP_WATCH = new ThreadLocal<>();

    public static void start(String string) {
        if (Objects.nonNull(CURRENT_STOP_WATCH.get())) {
            CURRENT_STOP_WATCH.remove();
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(string);
        CURRENT_STOP_WATCH.set(stopWatch);
        print(null);
    }

    public static void check() {
        if (Objects.nonNull(CURRENT_STOP_WATCH.get())) {
            StopWatch stopWatch = CURRENT_STOP_WATCH.get();
            stopWatch.stop();
            print(stopWatch);
        } else {
            print(null);
        }
        CURRENT_STOP_WATCH.remove();
        StopWatch newStopWatch = new StopWatch();
        newStopWatch.start();
        CURRENT_STOP_WATCH.set(newStopWatch);
    }

    public static void stop() {
        if (Objects.isNull(CURRENT_STOP_WATCH.get())) {
            return;
        }
        StopWatch stopWatch = CURRENT_STOP_WATCH.get();
        stopWatch.stop();
        print(stopWatch);
        CURRENT_STOP_WATCH.remove();
    }

    public static void print(StopWatch stopWatch) {
        Thread thread = Thread.currentThread();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[3];
        StringJoiner stringJoiner = new StringJoiner(":");
        stringJoiner.add(thread.getName())
                .add(stackTraceElement.getClassName())
                .add(String.valueOf(stackTraceElement.getLineNumber()));
        if (Objects.nonNull(stopWatch)) {
            stringJoiner.add(String.valueOf(stopWatch.getTotalTimeSeconds()));
        } else {
            stringJoiner.add("start");
        }
        System.out.println(stringJoiner.toString());
    }

}
