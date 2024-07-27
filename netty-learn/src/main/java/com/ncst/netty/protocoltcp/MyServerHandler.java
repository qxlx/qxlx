package com.ncst.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;


/**
 * @author i
 * @create 2020/9/20 15:50
 * @Description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务端接收数据如下:");
        System.out.println("长度=："+len);
        System.out.println("内容=:"+new String(content,Charset.forName("utf-8")));

        System.out.println("服务器接收到消息数量:"+this.count++);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
