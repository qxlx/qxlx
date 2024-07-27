package com.ncst.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author qxlx
 * @date 2024/7/27 15:30
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10000);

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
    }

}
