package com.qxlx.structural.proxy;

import com.qxlx.structural.proxy.dynamic.Calculator;
import com.qxlx.structural.proxy.dynamic.CalculatorProxy;
import com.qxlx.structural.proxy.dynamic.MyCalculator;

public class Test {
    public static void main(String[] args) {
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        proxy.add(1,1);
        System.out.println(proxy.getClass());
    }
}