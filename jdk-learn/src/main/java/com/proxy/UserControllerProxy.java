package com.proxy;

/**
 * @author qxlx
 * @date 2024/7/20 22:02
 */
public class UserControllerProxy implements IUserController{

    private IUserController userController;

    public UserControllerProxy(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public void register(Long uid) {
        final long startTime = System.currentTimeMillis();
        userController.register(uid);
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Override
    public void login(Long uid) {
        final long startTime = System.currentTimeMillis();
        userController.register(uid);
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
