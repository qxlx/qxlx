package com.ncst.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author i
 * @create 2020/9/20 11:48
 * @Description
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //加入一个出栈的handler
        ChannelPipeline pipeline = ch.pipeline();
        //编码器  Long->Byte 【客户端】
        pipeline.addLast(new MyLongToByteEncoder());
        //发送和获取数据
        pipeline.addLast(new MyClientHandler());
    }
}
