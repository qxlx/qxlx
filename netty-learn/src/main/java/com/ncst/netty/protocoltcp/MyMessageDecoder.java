package com.ncst.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author i
 * @create 2020/9/20 16:29
 * @Description
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode...");
        //将得到二进制字节码->MessageProtoal 数据包对象
        int lenth = in.readInt();
        byte[] bytes = new byte[lenth];
        in.readBytes(bytes);

        //封装成MessageProtocal  对象 放入out 传递下一个handler处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(lenth);
        messageProtocol.setContent(bytes);

        out.add(messageProtocol);
    }
}
