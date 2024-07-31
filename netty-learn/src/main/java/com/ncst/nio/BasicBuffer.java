package com.ncst.nio;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * @author i
 * @create 2020/9/9 17:39
 * @Description 测试buffer
 */
public class BasicBuffer {

    public static void main(String[] args) {
        //分配5个int字节大小空间
        IntBuffer intBuffer =  IntBuffer.allocate(5);
        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
        //存放数据
        for (int i = 0; i < intBuffer.capacity() ; i++) {
            intBuffer.put(2 * i );
        }

        //设置position limit设置为0 重新指向数据开始的位置
        intBuffer.flip();

        //获取数据
        while ( intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
