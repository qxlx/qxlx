package com.ncst.netty.codec;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author i
 * @create 2020/9/17 21:03
 * @Description 1.自定义Handler 需要继承 某一个ChannelInboundHandlerAdapter
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /***
     *  //读取客户端的数据
     * @param ctx  上下文对象，包含Pipeline、通道
     * @param msg  客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        StudentPOJO.Student student = (StudentPOJO.Student) msg;
        System.out.println("客户端发送的数据"+student.getId()+"\t"+student.getName());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //write + flush 将数据写入到缓冲 并刷新
        //需要将发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端...汪汪汪", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
