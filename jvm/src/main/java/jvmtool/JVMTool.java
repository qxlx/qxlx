package jvmtool;



/**
 * @author qxlx
 * @date 2024/3/1 21:46
 */
public class JVMTool {

    public static final int intData = 666;
    public static User user = new User();

    public static void main(String[] args) throws InterruptedException {
        JVMTool jVMTool = new JVMTool();
        while (true) {
            jVMTool.compute();
        }
    }

    public int compute () {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static class User {

    }

}
