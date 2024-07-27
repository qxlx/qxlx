package com.ncst.netty.codec;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * @author i
 * @create 2020/9/17 20:44
 * @Description
 */
public class NettyServer {

    /***
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //创建bossGroup和 WorkerGroup
        //bossGroup 只处理连接处理
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        //workGroup 真正的和客户端业务处理
        EventLoopGroup workGroup = new NioEventLoopGroup();

        //创建服务端启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            //链式编程来设置
            bootstrap.group(bossGroup, workGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NIOServerChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //创建一个通道测试对象(匿名对象)
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //给管道添加一个处理器

                            ch.pipeline().addLast("decoder",new ProtobufDecoder(StudentPOJO.Student.getDefaultInstance()));

                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给我们的workGroup的EventLoop对应的管道设置处理器

            System.out.println("服务器准备好了...");

            //绑定一个端口 并且同步
            //启动服务器 并绑定端口
            ChannelFuture channelFuture = bootstrap.bind(6688).sync();

            //给cf 注册监听器 监控我们关心的事件
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口 成功");
                    } else {
                        System.out.println("监听端口 失败");
                    }
                }
            });

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}
