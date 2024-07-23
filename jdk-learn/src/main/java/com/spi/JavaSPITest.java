package com.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author qxlx
 * @date 2024/7/4 22:20
 */
public class JavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<Phone> phoneServiceLoader = ServiceLoader.load(Phone.class);
        Iterator<Phone> iterator = phoneServiceLoader.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
