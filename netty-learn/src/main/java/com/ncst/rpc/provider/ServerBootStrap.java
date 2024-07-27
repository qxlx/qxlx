package com.ncst.rpc.provider;


import com.ncst.rpc.netty.NettyServer;

/**
 * @author i
 * @create 2020/9/26 17:38
 * @Description  会启动一个服务调用者，就是NettyServer
 */
public class ServerBootStrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",8888);
    }

}
