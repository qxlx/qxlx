package oom;

/**
 * @author qxlx
 * @date 2024/2/25 18:41
 *  -Xms10m -Xmx10m
 *  堆内存大小为10M
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
        // 创建对象 12MB对象
        byte [] bytes = new byte[12 * 1024 * 1024];
    }

}
