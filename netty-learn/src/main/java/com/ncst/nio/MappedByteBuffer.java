package com.ncst.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author i
 * @create 2020/9/10 21:40
 * @Description MapedByteBuffer可以操作堆外内存
 */
public class MappedByteBuffer {

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("d://a.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        //读写模式 0 可以直接修改的起始位置 映射到内存中的大小
        java.nio.MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(1,(byte)'H');
        mappedByteBuffer.put(5,(byte)'A');
        randomAccessFile.close();
        System.out.println("修改成功!");

    }


}
