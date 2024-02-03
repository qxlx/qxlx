package com.jia.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author qxlx
 * @date 2024/1/29 22:39
 */
public class OrderEventFactory implements EventFactory<Data> {

    @Override
    public Data newInstance() {
        return new Data();
    }
}
