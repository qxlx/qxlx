package com.ncst.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author i
 * @create 2020/9/18 17:35
 * @Description
 */
public class TestServer {

    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //Bootstarp是引导，一个netty应用通常由一个Bootstrap开始，主要作用是配置整个netty
            //串联各个组件，Netty中Bootstrap->客户端启动类
            //ServerBootstrap->服务端启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置服务端 boos worker
            //channel 服务端的通道实现
            //option给接收通道添加配置
            //handler -> bossGroup -> 业务处理类
            //childHandler-> workerGroup -> 业务处理类
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new TestServerInitializer());
            //bing绑定端口
            //IO异步的，具体实现通过Future和ChannelFuture 注册一个监听， 成功or失败会自动注册监听
            ChannelFuture channelFuture = bootstrap.bind(6668).sync();
            //sync() 异步操作执行完毕
            
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
