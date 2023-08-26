package com.jia.syn;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author jiabaobao
 * @date 2023/8/26 4:52 PM
 */
public class ObjectTest {

    public static void main(String[] args) {
//        System.out.println(VM.current().details());
        //        System.out.println(VM.current().objectAlignment());
        Object obj = new Object();
        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

    }

}
