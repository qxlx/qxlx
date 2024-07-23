package ch11;

/**
 * @author qxlx
 * @date 2024/7/22 08:07
 */
public abstract class Logger {

    public void logger() {
        System.out.println("打印日志方式");
        doLogger();
    }

    public abstract void doLogger();

}

class FileLogger extends Logger {

    @Override
    public void doLogger() {
        System.out.println("文件输出方式 打印logger");
    }
}

class MessageQueueLogger extends Logger {

    @Override
    public void doLogger() {
        System.out.println("消息队列打印输出logger");
    }
}