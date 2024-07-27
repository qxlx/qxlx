package com.ncst.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author i
 * @create 2020/9/10 20:16
 * @Description
 *          read() 从通道中读取数据到缓冲区中
 *          write() 把缓冲区中数据写入到通道中
 *
 *          transferForm() 从目标通道复制到当前通道
 *          transferTo() 把数据从当前通道复制目标通道
 *
 */
public class NIOChannel03 {

    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("d://b.txt");
        FileChannel fileChannel2 = fileOutputStream.getChannel();

        //分配一个固定大小的缓冲区
        ByteBuffer buffer =  ByteBuffer.allocate(512);

        //读取数据
        while (true) {
            //必须将缓冲区中的数据进行删除
            buffer.clear();
            //从通道中读取数据
            int read = fileChannel.read(buffer);
            System.out.println("read:"+read);
            //如果读取不到数据 直接跳出
            if (read == -1) {
                break;
            }
            //每次缓冲区中读取数据 都将position位置移动到数据开始的位置
            buffer.flip();
            fileChannel2.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
