package com.ncst.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author i
 * @create 2020/9/19 16:58
 * @Description
 */
public class MyServer {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //http协议 http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            //块方式写的  添加ChunkedWrite处理器
                            pipeline.addLast(new ChunkedWriteHandler());

                            //HttpObjectAhhrehator  http数据分段传输  将多个段聚合起来
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            //websocket数据以帧的形式传递
                            //可以看到websocketframe
                            //Chrome request ws://localhost:7000/hello 表示请求的url
                            //WebSocketServerProtocoHandler 核心功能是将http协议升级为ws协议
                            //保持长连接
                            pipeline.addLast(new WebSocketServerProtocolHandler("/qxlx"));
                            //自定义的handler  处理业务逻辑
                            pipeline.addLast(new MyTextWebSocketFrameHandler());

                        }
                    });

            ChannelFuture channelFuture = bootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
