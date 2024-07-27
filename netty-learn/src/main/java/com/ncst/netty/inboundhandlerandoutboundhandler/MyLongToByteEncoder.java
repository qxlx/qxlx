package com.ncst.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author i
 * @create 2020/9/20 11:50
 * @Description
 */
public class MyLongToByteEncoder extends MessageToByteEncoder <Long>{

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("1...encode...被调用...");
        System.out.println("msg:"+msg);
    }
}
