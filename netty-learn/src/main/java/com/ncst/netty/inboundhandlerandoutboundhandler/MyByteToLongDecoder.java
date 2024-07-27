package com.ncst.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author i
 * @create 2020/9/20 11:40
 * @Description
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /***
     *
     * @param ctx 上下文
     * @param in  入栈的bytebuff
     * @param out  list集合，将解码后的数据传递给下一个handler处理。
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //因为long 8个字节
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
