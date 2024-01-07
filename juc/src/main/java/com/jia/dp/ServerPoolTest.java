package com.jia.dp;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * @author qxlx
 * @date 2023/12/31 10:33 PM
 */
public class ServerPoolTest {

    public static void main(String[] args) throws IOException {

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(10,20,30000,TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8088));

        while (true) {
            SocketChannel sc = ssc.accept();
            threadPoolExecutor.execute(() -> {
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
            });
        }
    }

}
