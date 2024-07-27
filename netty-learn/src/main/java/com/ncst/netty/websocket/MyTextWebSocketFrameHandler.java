package com.ncst.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @author i
 * @create 2020/9/19 17:17
 * @Description
 *          类型 一个文本帧(frame)
 */
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler <TextWebSocketFrame>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("服务器端收到消息:"+msg.text());

        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间"+LocalDateTime.now()+" "+msg.text()));
    }

    //客户端连接后会触发 这个方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //id表示唯一的值，LongText 是唯一的
        System.out.println("handlerAdded 被调用:"+ctx.channel().id().asLongText());
        System.out.println("handlerAdded 被调用:"+ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved 被调用:"+ctx.channel().id());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生..."+cause.getMessage());
        ctx.channel().close();//关闭通道
    }
}
