package com.jia.dp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2023/12/31 10:33 PM
 */
public class ServerTest {

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8088));

        while (true) {
            SocketChannel sc = ssc.accept();
            new Thread(() -> {
                ByteBuffer rb = ByteBuffer.allocate(1024);
                try {
                    sc.read(rb);
                    TimeUnit.SECONDS.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " 接收的数据:" + rb.toString());
                    ByteBuffer wb = (ByteBuffer) rb.flip();
                    sc.write(wb);
                    sc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + Math.random()).start();
        }
    }

}
