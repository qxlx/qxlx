package com.qxlx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jiabaobao
 * @date 2023/5/14 10:13 PM
 */
public class RedisServerNIO {

    static List<SocketChannel> socketChannelList = new ArrayList<>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("127.0.0.1",6379));
        socketChannel.configureBlocking(false);

        while (true) {
            for (SocketChannel element : socketChannelList) {
                int read = element.read(byteBuffer);
                if (read > 0) {
                    System.out.println("---读取数据");
                    byteBuffer.flip();
                    byte [] bytes = new byte[read];
                    byteBuffer.get(bytes);
                    System.out.println(new String(bytes));
                    byteBuffer.clear();
                }
            }

            SocketChannel accept = socketChannel.accept();
            if (Objects.nonNull(accept)) {
                System.out.println("连接成功");
                accept.configureBlocking(false);
                socketChannelList.add(accept);
                System.out.println("list:"+socketChannelList.size());
            }
        }
    }
}
