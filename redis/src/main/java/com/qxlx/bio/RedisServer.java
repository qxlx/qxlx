package com.qxlx.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiabaobao
 * @date 2023/5/14 9:40 PM
 */
public class RedisServer {

    public static void main(String[] args) throws IOException {
        byte [] bytes = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(6379);

        while (true) {
            System.out.println("1.建立连接");
            Socket accept = serverSocket.accept();
            System.out.println("2.连接成功");

            //多个线程处理read数据读取
            new Thread(()-> {
                InputStream inputStream = null;
                try {
                    inputStream = accept.getInputStream();
                    int length = -1;
                    System.out.println("3.等待读取数据");

                    while ((length =inputStream.read(bytes)) != -1) {
                        System.out.println("4.读取到数据");
                        System.out.println(new String(bytes));
                    }
                    System.out.println("5.数据读取结束");
                    inputStream.close();
                    accept.close();
                    System.out.println("6.关闭资源结束");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
