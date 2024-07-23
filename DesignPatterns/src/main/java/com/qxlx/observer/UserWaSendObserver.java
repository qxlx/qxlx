package com.qxlx.observer;

/**
 * @author qxlx
 * @date 2024/4/13 22:30
 */
public class UserWaSendObserver implements Observer{

    @Override
    public void notify(String message) {
        System.out.println("用户注册成功,发送了wa通知");
    }
}
