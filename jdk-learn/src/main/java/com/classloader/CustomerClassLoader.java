package com.classloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qxlx
 * @date 2024/6/23 21:55
 */
public class CustomerClassLoader extends ClassLoader{

    private final String classesDir;

    public CustomerClassLoader(String claeesDir) {
        this.classesDir = claeesDir;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classData;
        try {
            // 构建类文件的路径
            String classFilePath = classesDir + "/" + name.replace('.', '/') + ".class";
            Path path = Paths.get(classFilePath);

            // 读取类文件的字节码
            classData = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class not found: " + name, e);
        }

        // 将字节码转换为 Class 对象
        return defineClass(name, classData, 0, classData.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 创建自定义类加载器，指定类文件目录
        CustomerClassLoader customClassLoader = new CustomerClassLoader("path/to/classes");

        // 使用自定义类加载器加载类
        Class<?> clazz = customClassLoader.loadClass("com.example.MyClass");

        // 创建类实例并调用方法
        Object instance = clazz.getDeclaredConstructor().newInstance();
        clazz.getMethod("myMethod").invoke(instance);
    }

}
