package com.jia.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

/**
 * @author qxlx
 * @date 2024/1/29 22:21
 */
public class Demo {

    public static void main(String[] args) {
        Disruptor<Data> disruptor = new Disruptor<Data>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy() //等待策略
        );

        disruptor.handleEventsWith((EventHandler<? super Data>) new EventHanderConsumer());
        disruptor.start();

        RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
        EventProducer eventProducer = new EventProducer(ringBuffer);

        for (int i = 0; i < 100; i++) {
            eventProducer.send(1,"fix"+i);
        }
    }

}
