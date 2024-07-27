package com.ncst.nio;

import java.nio.IntBuffer;

/**
 * 日拱一卒，不期速成
 *
 * @Auther: i
 * @Date: 2020/10/25/14:54
 * @Description:
 */
public class BasicBuffer2 {

    /***
     * BIO是基于字节和字符流操作，而NIO是基于缓冲区和通道操作。选择器进行多路复用技术实现
     * BIO是阻塞的 NIO是非阻塞的
     * @param args
     */
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity() ; i++) {
            intBuffer.put(i * 2);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
