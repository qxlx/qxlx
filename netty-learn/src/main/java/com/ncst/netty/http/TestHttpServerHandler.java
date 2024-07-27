package com.ncst.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author i
 * @create 2020/9/18 17:35
 * @Description
 *  httpObject 客户端和服务器端相互通信的数据被封装成httpObject类型。
 *
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler <HttpObject>{

    //读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        //判断 msg 是不是httprequest请求
        if (msg instanceof HttpRequest) {
            System.out.println("msg类型:"+msg.getClass());
            System.out.println("客户端地址:"+ctx.channel().remoteAddress());

            //uri过滤指定资源
            HttpRequest httpRequest = (HttpRequest) msg;
            URI uri = new URI(httpRequest.uri());

            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 /favicon.ico，不做响应");
                return;
            }

            //恢复信息给浏览器
            ByteBuf content = Unpooled.copiedBuffer("hello, server", CharsetUtil.UTF_8);

            //构造一个http的响应 既httpresponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            //send
            ctx.writeAndFlush(response);

        }
    }
}
