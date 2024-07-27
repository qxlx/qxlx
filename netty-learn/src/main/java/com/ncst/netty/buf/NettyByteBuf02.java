package com.ncst.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @author i
 * @create 2020/9/19 14:29
 * @Description
 */
public class NettyByteBuf02 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);

        //api
        if (byteBuf.hasArray()) {
            byte[] array = byteBuf.array();

            System.out.println(new String(array,CharsetUtil.UTF_8));
            System.out.println("bytebuf:"+byteBuf);
            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
        }
    }

}
