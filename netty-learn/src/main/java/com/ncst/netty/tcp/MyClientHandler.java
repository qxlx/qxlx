package com.ncst.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author i
 * @create 2020/9/20 15:45
 * @Description
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count = 0;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //使用客户端发送10条数据 hello,server
        for (int i = 0; i < 10 ; i++) {
            ByteBuf buffer = Unpooled.copiedBuffer("hello server" + i, Charset.forName("utf-8"));
            ctx.writeAndFlush(buffer);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte [] buf = new byte[msg.readableBytes()];
        msg.readBytes(buf);

        String message = new String(buf,Charset.forName("utf-8"));
        System.out.println("客户端接收消息="+message+"\t");
        System.out.println("客户端接收消息的次数: "+this.count++);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
