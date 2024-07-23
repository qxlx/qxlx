package com.qxlx.observer;

/**
 * @author qxlx
 * @date 2024/4/13 22:25
 */
public interface Subject {

    /**
     * 注册
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除
     * @param observer
     */
    void deleteObserver(Observer observer);

    /**
     * 发送事件
     * @param message
     */
    void notifyObservers(String message);
}
