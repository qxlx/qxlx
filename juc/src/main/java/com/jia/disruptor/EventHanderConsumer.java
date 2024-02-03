package com.jia.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @author qxlx
 * @date 2024/1/29 22:44
 */
public class EventHanderConsumer implements EventHandler<Data> {

    @Override
    public void onEvent(Data data, long l, boolean b) throws Exception {
        System.out.println("消费者获取数据"+data.getUid());
    }
}
