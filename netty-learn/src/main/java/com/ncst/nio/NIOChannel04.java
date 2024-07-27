package com.ncst.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author i
 * @create 2020/9/10 20:59
 * @Description
 */
public class NIOChannel04 {

    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("d://1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d://2.jpg");

        FileChannel srcChanne = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();

        //从目标通道复制到当前通道
        srcChanne.transferFrom(destChannel,0, srcChanne.size());


    }

}
