package com.ncst.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author i
 * @create 2020/9/9 16:41
 * @Description NIO模型 服务端
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        //1.创建线程池来接收客户端的请求处理
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        //创建一个服务端
        ServerSocket serverSocket = new ServerSocket(10000);

        System.out.println("server start ...");

        while (true) {
            //打印当前线程
            System.out.println("  : thread-Name:" + Thread.currentThread().getName());
            //循环接收 处理客户端的请求
            final Socket client = serverSocket.accept();
            System.out.println("server wait request...");
            if (client != null) {
                //创建一个线程来接收每个服务
                threadPool.execute(new Runnable() {
                    public void run() {
                        //处理当前接收到的数据
                        handler(client);
                    }
                });
            }
        }
    }

    /***
     * 处理当前数据
     * @param client
     */
    private static void handler(Socket client) {
        //打印当前线程
        System.out.println( " thread-Name:" + Thread.currentThread().getName());
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = client.getInputStream();
            while (true) {
                System.out.println("server wait data...");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //打印数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("资源关闭...");
            }
        }

    }

}
