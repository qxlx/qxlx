package com.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/7/20 22:05
 */
public class UserControolerTest {

    public static void main(String[] args) {
        //动态代理创建的class文件存储到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/qxlx/work/qxlx/qxlx/jdk-learn/src/main/java/com/proxy");
        //通过cglib动态代理获取代理对象的过程 创建调用的对象
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(UserController.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new ProxyFactory(new UserController()));
        //创建代理对象
        UserController userControllerProxy = (UserController)enhancer.create();

        userControllerProxy.login(1L);
    }

    private static void extracted() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IUserController iUserController = new UserController();
        CtrlProxyHandler handler = new CtrlProxyHandler(iUserController);
        IUserController userControllerProxy = (IUserController) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(), UserController.class.getInterfaces(),handler);
        userControllerProxy.login(1L);
    }

    private static void extracted2() {
        IUserController userController = new UserController();
        IUserController iUserControllerProxy = new UserControllerProxy(userController);

        iUserControllerProxy.register(1L);
        iUserControllerProxy.login(1L);
    }

}
