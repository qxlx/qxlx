package com.qxlx.classloader;

/**
 * @author qxlx
 * @date 2024/2/19 22:32
 */
public class ClassLoaderDemo {

    public static class ClassLoaderA extends ClassLoader {

    }


    public static class ClassLoaderB extends ClassLoader {

        public ClassLoaderB(ClassLoader parent) {
            super(parent);
        }
    }

    public static void main(String[] args) {
        ClassLoaderB loader = new ClassLoaderB(new ClassLoaderA());

        System.out.println(loader);

        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        System.out.println(loader.getParent().getParent().getParent());
        System.out.println(loader.getParent().getParent().getParent().getParent());
    }

}
