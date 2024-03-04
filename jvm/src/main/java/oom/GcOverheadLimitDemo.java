package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qxlx
 * @date 2024/2/25 21:33
 *
 *  JVM参数配置: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 */
public class GcOverheadLimitDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(++i).intern());
        }
    }

}
