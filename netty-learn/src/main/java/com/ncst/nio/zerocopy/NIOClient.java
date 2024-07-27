package com.ncst.nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author i
 * @create 2020/9/16 20:31
 * @Description
 */
public class NIOClient {

    public static void main(String[] args) throws  Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8888));
        String fileName = "protoc-3.6.1-win32.zip";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long starTime = System.currentTimeMillis();

        //linux下一个transferTo 方法爱就可以完成传输
        //windows 一次调用transferTo 只能发送8MB文件

        //底层 零拷贝
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送的总的字节数:"+ transferCount+ "耗时:"+(System.currentTimeMillis()-starTime));
    }

}
