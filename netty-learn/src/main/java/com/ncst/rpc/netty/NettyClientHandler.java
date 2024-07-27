package com.ncst.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author i
 * @create 2020/9/26 19:30
 * @Description
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context; //上下文
    private String result;
    private String para;//客户端调用方法时，传入的参数


    @Override //与服务器的连接 创建成功会就会被调用  1
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;//初始化 在其他方法会使用ctx
    }

    //2
    void setPara(String para) {
        this.para = para;
    }


    @Override  //被代理对象调用 发送数据给服务器，-> wait 等待被唤醒 ->返回结果  3
    public synchronized Object call() throws Exception {
        context.writeAndFlush(para);
        //进行wait
        System.out.println("wait 等待服务端响应...");
        wait(); //等待channelRead 方法获取到服务器的结果后 返回
        return result;//服务方返回的结果
    }

    @Override//收到服务器的数据后，就会调用 4
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();//唤醒等待的线程
        System.out.println("notify 服务端响应了...");
    }

    @Override//异常时关闭
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
