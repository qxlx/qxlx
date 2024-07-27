package com.ncst.netty.simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

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

        //对于比较耗时长的业务，异步执行 提交channel

        //解决方案1. 用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 我是服务端...", CharsetUtil.UTF_8));
            }
        });

        //因为是同一个线程 所以会30s以后在执行
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 我是服务端 2", CharsetUtil.UTF_8));
            }
        });

        //用户自定义定时任务， 该任务是提交到scheduleTaskQueue中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端...qxlxi ", CharsetUtil.UTF_8));
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println("netty...");

//        System.out.println("服务器读取线程:"+Thread.currentThread().getName());
//
//        System.out.println("server ctx:"+ ctx);
//
//        System.out.println("看看channel 和 pipeline的关系");
//        Channel channel = ctx.channel();
//        ChannelPipeline pipeline = ctx.pipeline();  //双向链表  出栈和入栈问题
//
//
//        //将msg转换成byteBuffer
//        ByteBuf byteBuf = (ByteBuf)msg;
//        System.out.println("客户端发送数据："+byteBuf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端ip:"+channel.remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //write + flush 将数据写入到缓冲 并刷新
        //需要将发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 服务端的数据读取完毕...", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
