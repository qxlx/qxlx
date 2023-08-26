package com.qxlx.behavioral.template;

/**
 * @author jiabaobao
 * @date 2022/4/12 10:50 PM
 */
public abstract class AbstractFileDown {

    public void reconnlion() {
        //1.获取行方文件
        //2.拉去自己数据
        //3.进行对账处理
        System.out.println("1.获取行方文件");
        down();
        System.out.println("2.拉去自己数据");
        System.out.println("3.进行对账处理");
    }

    protected abstract void down();

}
