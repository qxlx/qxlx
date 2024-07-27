package com.ncst.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author i
 * @create 2020/9/26 19:45
 * @Description
 */
public class NettyClient {

    //创建一个线程池
    private static ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    private static NettyClientHandler client;

    //编写方法使用代理模式 获取一个代理对象
    public Object getBean(final Class<?> serviceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serviceClass}, (proxy, method, args) -> {
                    //客户端每调用一次 会反复执行
                    if (client == null) {
                        System.out.println("init()...");
                        initClient();
                    }
                    //TODO agrs
                    System.out.println("args:"+args);
                    //设置发送给服务器端的参数  协议头 agrs[0] hello
                    client.setPara(providerName + args[0]);
                    return threadPool.submit(client).get();
                });
    }

    //初始化客户端
    private static void initClient() {
        client = new NettyClientHandler();
        //常见EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(client);
                        //new 就不行？？？ todo
                    }
                });

        try {
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
