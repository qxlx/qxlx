package com.ncst.netty.hearbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author i
 * @create 2020/9/19 16:34
 * @Description
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /***
     *
     * @param ctx
     * @param evt  事件
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            //转型
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;

            switch (event.state()) {
                case READER_IDLE :
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE :
                    eventType = "写空闲";
                    break;
                case ALL_IDLE :
                    eventType = "一直空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"---超时事件发生:"+eventType);
            System.out.println("服务器做响应的处理:");

            ctx.channel().close();
        }
    }
}
