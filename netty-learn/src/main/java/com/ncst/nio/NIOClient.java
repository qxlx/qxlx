package com.ncst.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author i
 * @create 2020/9/16 16:22
 * @Description
 *
 * 1.servetChangel
 * 2.
 */
public class NIOClient {

    public static void main(String[] args) throws Exception {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞模式
        socketChannel.configureBlocking(false);
        //提供服务器端的ip port
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",6666);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            //fail
            while (!socketChannel.finishConnect()) {
                System.out.println("连接需要时间，客户端不会阻塞，可以做其他工作！");
            }
        }

        //如果连接成功，就发送数据。
        String str = "qxlxi";
        //Wraps a byte array into a buffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //发送数据 将buffer数据写入channel
        socketChannel.write(byteBuffer);
        System.in.read();

    }

}
