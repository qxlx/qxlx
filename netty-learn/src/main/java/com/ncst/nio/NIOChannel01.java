package com.ncst.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author i
 * @create 2020/9/10 17:54
 * @Description
 */
public class NIOChannel01 {

    // 文件->Buffer->Channel->文件输出流
    // 创建一个文件输出流，从输出流中拿到FileChannel通道
    // 将文件写到缓冲区中，缓冲区进行flip() 在通道的角度上 将缓冲区的内容写入到通道中
    public static void main(String[] args) throws Exception {
        String str = "hi,qxlxi";
        //输出流 在d盘上写一个文件
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qxlx/work/qxlx/qxlx/netty-learn/src/main/java/com/ncst/nio/a.txt");

        //获取输出流的通道
        FileChannel channel = fileOutputStream.getChannel();

        //创建一个字节
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将文件写入到缓冲区中
        byteBuffer.put(str.getBytes());

        //刷新
        byteBuffer.flip();

        //把缓冲区的内容写入到通道中
        channel.write(byteBuffer);

        //关闭资源
        channel.close();
        fileOutputStream.close();

    }

}
