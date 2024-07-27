package com.ncst.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author i
 * @create 2020/9/18 17:35
 * @Description
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    //初始化
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        //加入一个netty,提供的httpServerCode
        //netty提供的一个编码 解码器
        pipeline.addLast("myHttpServerCodec",new HttpServerCodec());
        //增加自定义的handler
        pipeline.addLast("myhandler",new TestHttpServerHandler());
    }
}
