package com.ncst.dp;

import io.netty.channel.Channel;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author i
 * @create 2020/9/23 17:08
 * @Description
 */
public class TestLainProgram {

    public static void main(String[] args) {
        Student student = new Student();
        //链式编程的核心是通过设置相关的属性，然后返回一个对象类型 this. 就可以直接调用下一个方法
        student.setName("qxlxi").setAge("23").setMoney("no money").setOffer("offer");

        //通过反射创建对象
        Channel channel = new ReflectiveChannelFactory(NioServerSocketChannel.class).newChannel();
        if (channel instanceof NioServerSocketChannel) {
            System.out.println("T");
        }

    }

}
