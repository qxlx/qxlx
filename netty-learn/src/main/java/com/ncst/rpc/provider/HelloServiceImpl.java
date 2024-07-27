package com.ncst.rpc.provider;


import com.ncst.rpc.publicinterface.HelloService;

/**
 * @author i
 * @create 2020/9/26 17:36
 * @Description  提供者
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String str) {
        System.out.println("消费者消息:"+str);
        return "qxlxi";
    }
}
