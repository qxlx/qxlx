package com.ncst.netty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author i
 * @create 2020/9/19 15:34
 * @Description
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler <String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }

}
