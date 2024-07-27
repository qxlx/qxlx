package com.ncst.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;


/**
 * @author i
 * @create 2020/9/20 15:50
 * @Description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte [] byteBuff = new byte [msg.readableBytes()];
        msg.readBytes(byteBuff);

        //将buffer转成字符串
        String message = new String(byteBuff, Charset.forName("utf-8"));

        System.out.println("服务器端接收数据:"+message+"\t");
        System.out.println("服务器接收到消息量:"+(this.count++));
        System.out.println();


        //服务器回送数据给客户端，
        ByteBuf buf = Unpooled.copiedBuffer(UUID.randomUUID().toString(), Charset.forName("utf-8"));
        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
