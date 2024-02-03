package com.jia.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @author qxlx
 * @date 2024/1/29 22:40
 */
public class EventProducer {

    private RingBuffer<Data> ringBuffer;

    public EventProducer(RingBuffer<Data> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void send(long value,String name) {
        long next = ringBuffer.next();
        Data data = ringBuffer.get(next);

        // 写入消息数据
        data.setUid(name);

        //发布事件
        ringBuffer.publish(next);
    }

}
