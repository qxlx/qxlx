package com.ncst.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author i
 * @create 2020/9/10 19:53
 * @Description
 */
public class NIOChannel02 {

    public static void main(String[] args) throws  Exception{
        File file = new File("/Users/qxlx/work/qxlx/qxlx/netty-learn/src/main/java/com/ncst/nio/a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过输入流创建通道
        FileChannel channel = fileInputStream.getChannel();

        //创建缓冲
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)channel.size());

        //将通道中的数据读入缓冲区
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        //关闭资源
        fileInputStream.close();
    }

}
