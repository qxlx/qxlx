package com.ncst.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author i
 * @create 2020/9/19 14:43
 * @Description
 */
public class GroupChatServer {

    private int port;//监听端口

    public GroupChatServer (int port) {
        this.port = port;
    }

    //编写run方法，处理客户端的请求
    public void run () throws  Exception {
        //创建两个线程
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            //获取到pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            //向pipeline加入一个解码器
                            pipeline.addLast("decoder",new StringDecoder());
                            //向pipeline加入一个编码器
                            pipeline.addLast("encoder",new StringEncoder());
                            //加入自己的业务处理
                            pipeline.addLast(new GroupChatServerHandler());
                        }

                    });
            System.out.println("netty server start...");
            //Future  异步操作的占位符。在将来某个时刻完成，并提供对结果的访问
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();


            //监听关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws  Exception{
        new GroupChatServer(7000).run();
    }

}
