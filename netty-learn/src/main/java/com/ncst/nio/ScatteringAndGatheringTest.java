package com.ncst.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author i
 * @create 2020/9/12 21:43
 * @Description Scattering : 将数据写入buffer 可以采用buffer数组
 * Gathering  ：将数据从buffer中读出，可以采用buffer数组
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9000);

        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(2);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int messageLen = 0;
            while (messageLen <= 7) {
                long l = socketChannel.read(byteBuffers);
                messageLen += l;
                System.out.println("byteRead:"+l);
                Arrays.asList(byteBuffers).stream().map(buffer -> "postion=" + buffer.position() + ", limit=" + buffer.limit()).forEach(System.out::println);
            }

            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据显示到客户端
            long byteWrite = 0;
            while (byteWrite < 8) {
                long l = socketChannel.write(byteBuffers);
                byteWrite+=l;
            }
            //将所有的buffer 进行clear
            Arrays.asList(byteBuffers).forEach(buffer-> {
                buffer.clear();
            });

        }

    }

}
