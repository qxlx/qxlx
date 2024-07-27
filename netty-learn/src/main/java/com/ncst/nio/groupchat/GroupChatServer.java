package com.ncst.nio.groupchat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author i
 * @create 2020/9/16 17:29
 * @Description
 */
public class GroupChatServer {
    //定义属性
    private Selector selector;//选择器
    private ServerSocketChannel listenChannel;//服务器端通道
    private static final int PORT = 6667;

    //init
    public GroupChatServer() {

        //选择器
        try {
            //selector注册器
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将 listentChannel注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0) {
                    //遍历key集合
                    Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();

                        //监听
                        if (key.isAcceptable()) {
                            //获取socketChannel
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            //注册
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress()+" 上线...");
                        }

                        //read
                        if (key.isReadable()) {
                            //todo
                            readData(key);
                        }

                        //import note
                        keyIterator.remove();
                    }
                } else {
                    System.out.println("server wait...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    //读取客户端信息
    private void readData(SelectionKey key) {

        //定义一个channel
        SocketChannel channel = null;

        try {
            //获取channel
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将通道的数据到buffer
            int count = channel.read(byteBuffer);
            //有数据
            if (count > 0) {
                //将缓冲区的数据转成字符串
                String msg = new String(byteBuffer.array());
                System.out.println("from 客户端");

                //将消息转发给其他的客户端
                //todo
                sendOtherMsg(msg,channel);
            }
        } catch (Exception e) {
            try {
                System.out.println(channel.getRemoteAddress()+" 离线了...");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
        }

    }

    //将消息转发给其他客户端 为了排除转发给自己
    private  void sendOtherMsg(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中...");
        //遍历 所有注册到seletor 上的 socketChannel 排除
        for (SelectionKey key :  selector.keys()) {
            //通过key 取出对应的socketChannel
            Channel targetChannel = key.channel();
            if ( targetChannel instanceof SocketChannel && targetChannel != self) {
                //转型
                SocketChannel sc = (SocketChannel) targetChannel;
                //将msg 存储到buffer
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                //msg写入到socketChannel
                sc.write(byteBuffer);
            }
        }

    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }


}
