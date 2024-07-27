package com.ncst.bio;

import java.io.*;

/**
 * 日拱一卒，不期速成
 *
 * @Auther: i
 * @Date: 2020/10/25/16:56
 * @Description: 本身数组是对我们提供了一套API 那就是通过索引下标去操作数据。
 * 而如果我们通过ByteArrayInputStream 进行操作数据 那就是另一种高度抽象化的API
 */
public class ByteArrayInputStreamDemo {

    public static void main(String[] args) throws IOException {
        byte [] bytes = new byte[8];
        int length = 0;
        InputStream inputStream = new FileInputStream("F:\\java\\idea\\netty\\src\\main\\java\\com\\ncst\\bio\\file.txt");
        while ((length = inputStream.read(bytes)) != -1) {
            System.out.println(bytes.toString());
        }
    }

}
