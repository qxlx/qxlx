package com.ncst.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.ncst.rpc.consumer.ClientBootStrap;
import com.ncst.rpc.provider.HelloServiceImpl;

/**
 * @author i
 * @create 2020/9/26 19:17
 * @Description
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息 并调用我们的服务
        System.out.println("msg:"+msg);
        //客户端在调用服务器的api时，我们需要定义一个协议
        //比如 我们每次发消息时都必须以某个字符串开头 "HelloService#hello#xxx"
        if (msg.toString().startsWith(ClientBootStrap.providerName)) {
            //调用实现类的方法
            String result = new HelloServiceImpl().hello(msg.toString().
                    substring(msg.toString().lastIndexOf("#") + 1));
            //会写给客户端
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
