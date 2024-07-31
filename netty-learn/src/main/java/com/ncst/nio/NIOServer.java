package com.ncst.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author i
 * @create 2020/9/16 15:54
 * @Description
 *
 *
 */
public class NIOServer {

    public static void main(String[] args) throws Exception {
        //创建一个ServerSocketChannel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建一个选择器
        Selector selector = Selector.open();
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞的
        serverSocketChannel.configureBlocking(false);
        //将channel注册到selector上 接收事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println(""+Thread.currentThread().getName()+"  注册上的key:"+selector.keys().size()+" 事件发生的key:"+selector.selectedKeys().size());
        //循环等待客户端连接
        while (true) {
            //等待1秒中，没有 返回
            if (selector.select(1000) == 0) {
                System.out.println(Thread.currentThread().getName()+ " 服务器等待1s,没有结果");
                continue;
            }

            //获取响应事件集合，selectionKey集合
            //通过selectionKeys获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历key集合
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                //根据key对应的通道发生的事件作出不同的处理
                //连接事件 ON_ACCEPT
                if (selectionKey.isAcceptable()) {
                    //生成一个客户端serversocket
                    //方法是阻塞，但是由于是NIO模型，会马上执行。
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功。生成了一个"+socketChannel.hashCode());
                    //注册到selector 事件为读OP_READ 关联一个buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println(Thread.currentThread().getName()+"客户端连接后key:"+selector.selectedKeys().size());
                }

                //读事件  OP_READ
                if (selectionKey.isReadable()) {
                    //通过key 反向获取到对应的channel
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer byteBuffer = (ByteBuffer)selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println(Thread.currentThread().getName()+"from client :" + new String(byteBuffer.array()));
                }
                //手动删除 防止重复操作
                selectionKeyIterator.remove();
            }
        }
    }

}
