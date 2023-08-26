package com.qxlx.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jiabaobao
 * @date 2023/5/14 9:42 PM
 */
public class RedisClient01 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6379);

        OutputStream outputStream = socket.getOutputStream();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if (next.equalsIgnoreCase("quit")) {
                break;
            }
            outputStream.write(next.getBytes());
            System.out.println("写入数据成功");

            outputStream.close();
            socket.close();
        }
    }

}
