package com.ncst.netty.groupchat;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author i
 * @create 2020/9/19 15:22
 * @Description
 */
public class GroupChatClient {

    private final String HOST;
    private final int port;

    public GroupChatClient(String host,int port){
        this.HOST =  host;
        this.port =  port;
    }

    public void  run () throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //得到pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder",new StringDecoder());
                            pipeline.addLast("encoder",new StringEncoder());
                            //加入自定义的handler
                            pipeline.addLast(new GroupChatClientHandler());

                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(HOST, port).sync();

            Channel channel = channelFuture.channel();

            System.out.println("---" + channel.localAddress()+"---");

            //输入信息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                //channel发送出去
                channel.writeAndFlush(str);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        new GroupChatClient("localhost",7000).run();
    }

}
