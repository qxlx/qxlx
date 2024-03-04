package oom;

import java.nio.ByteBuffer;

/**
 * @author qxlx
 * @date 2024/2/25 21:51
 */
public class DirectMemorySizeDemo {

    // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void main(String[] args) {
        // 分配6M 堆外内存
        ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

}
