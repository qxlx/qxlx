package com.ncst.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author i
 * @create 2020/9/20 11:43
 * @Description
 */
public class MyServerHandler extends SimpleChannelInboundHandler <Long>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("3...从客户端读取到数据:"+ctx.channel().remoteAddress()+" 数据:"+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
