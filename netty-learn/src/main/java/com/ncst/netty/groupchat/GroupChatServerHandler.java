package com.ncst.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author i
 * @create 2020/9/19 14:54
 * @Description
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler <String>{

    //定义channel组，管理所有的channel
    //全区事件执行器
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //第一个执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入聊天信息 推送给其他在线的客户端
        //writeAndFlush 会将channelgroup所有的channel遍历 并发送  不需要自己遍历
        channels.writeAndFlush("[客户端]"+channel.remoteAddress() +" 加入聊天\n"+sdf.format(new Date()));
        channels.add(channel);
    }

    //提醒上线了
    //当一个新的连接已经被建立时，会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 上线了..."+sdf.format(new Date()));
    }

    //提醒离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 离线了..."+ sdf.format(new Date()));
    }

    //断开连接  推送给所有在线客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel  = ctx.channel();
        channels.writeAndFlush("[客户端]"+channel.remoteAddress()+" 离开了\n" + sdf.format(new Date()));
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取当前channel
        Channel channel = ctx.channel();
        //这时遍历 channelgroup 根据不同的情况 回送不同的消息
        channels.forEach(ch -> {
            if (channel != ch) { //不是当前的channel 直接转发
                ch.writeAndFlush("[客户]"+channel.remoteAddress() +" 发送消息"+msg+"\n");
            } else {
                ch.writeAndFlush("[自己发送了消息]"+ msg +"\n");
            }
        });
    }

    //发生异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
