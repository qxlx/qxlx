package com.fanshe;

import javafx.scene.paint.Stop;

/**
 * @author qxlx
 * @date 2024/1/28 21:33
 */
public class FanSheDemo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        // 创建Class对象 方式1
//        Class<?> clazz = Class.forName("com.fanshe.FanSheDemo");
//
//        // 方式2
//        Class<FanSheDemo> sheDemoClass = FanSheDemo.class;
//
//        // 方式3
//        FanSheDemo fanSheDemo = new FanSheDemo();
//        Class<? extends FanSheDemo> fanSheDemoClass = fanSheDemo.getClass();


        long star = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            C c = new C();
            c.f();
        }
        System.out.println("new:"+(System.currentTimeMillis() - star));


        long star2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Class<C> cClass = C.class;
            C c = cClass.newInstance();
            c.f();
        }
        System.out.println(System.currentTimeMillis() - star2);
    }

    public static class C {
        public void f() {}
    }

}
