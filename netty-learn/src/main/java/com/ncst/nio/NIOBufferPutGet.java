package com.ncst.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author i
 * @create 2020/9/10 21:11
 * @Description
 */
public class NIOBufferPutGet {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.putInt(100);
        byteBuffer.putDouble(100.0);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getDouble());
    }

}
