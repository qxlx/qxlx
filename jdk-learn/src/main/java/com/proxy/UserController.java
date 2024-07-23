package com.proxy;

import com.anotation.RateLimit;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/7/20 22:01
 */
public class UserController implements IUserController{


    @Override
    public void register(Long uid) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void login(Long uid) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
