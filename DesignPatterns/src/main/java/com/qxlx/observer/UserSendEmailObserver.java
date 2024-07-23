package com.qxlx.observer;

/**
 * @author qxlx
 * @date 2024/4/13 22:31
 */
public class UserSendEmailObserver implements Observer{

    @Override
    public void notify(String message) {
        System.out.println("用户注册成功,发送邮件通知!");
    }

}
