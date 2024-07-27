package com.ncst.rpc.consumer;

import com.ncst.rpc.netty.NettyClient;
import com.ncst.rpc.publicinterface.HelloService;

/**
 * @author i
 * @create 2020/9/26 20:00
 * @Description  
 */
public class ClientBootStrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient consumer = new NettyClient();
        //jdk proxy接口代理
        HelloService helloService =
                (HelloService) consumer.getBean(HelloService.class, providerName);

//        System.out.println("helloService:"+helloService.toString());

        //通过代理对象调用服务器提供者的方法(服务)
        String res = helloService.hello("你好 dubbo");
        System.out.println("服务器端 res:"+res);
    }


}
