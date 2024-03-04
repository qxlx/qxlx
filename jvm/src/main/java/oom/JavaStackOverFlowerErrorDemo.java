package oom;

/**
 * @author qxlx
 * @date 2024/2/25 18:38
 */
public class JavaStackOverFlowerErrorDemo {

    public static void main(String[] args) {
        f();
    }

    private static void f () {
        f();
    }

}
