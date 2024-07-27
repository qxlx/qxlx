package com.ncst.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.Buffer;

/**
 * @author i
 * @create 2020/9/19 11:20
 * @Description
 */
public class NettyByteBuf01 {

    public static void main(String[] args) {
        //创建一个ByteBuf
        //1.创建对象 该对象包含一个数组arr,是一个byte[10];
        //netty的buffer中，不需要使用filp 进行反转
        // 底层维护了一个readIndex 和 writeIndex
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10 ; i++) {
            byteBuf.writeByte(i);
        }

        System.out.println("capacity:"+byteBuf.capacity());

        //输出
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }
    }

}
