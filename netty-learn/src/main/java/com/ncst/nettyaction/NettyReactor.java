package com.ncst.nettyaction;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author i
 * @create 2020/9/19 20:38
 * @Description
 */
public class NettyReactor {

    public static void main(String[] args) {
        reactor01();
        reactor02();
        reactor03();
    }

    private static void reactor03() {
        //主从Reactor多线程模式
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workerGroup);
    }

    private static void reactor02() {
        //Reactor多线程模式
        //根据系统的核心进行计算 默认乘2
        EventLoopGroup eventGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(eventGroup);
    }

    private static void reactor01() {
        //Reactor 单线程模式
        EventLoopGroup eventGroup = new NioEventLoopGroup(1);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(eventGroup);
    }

}
