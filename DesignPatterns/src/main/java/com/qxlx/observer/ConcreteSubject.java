package com.qxlx.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qxlx
 * @date 2024/4/13 22:27
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new CopyOnWriteArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        // 1.同步调用
        // 2.异步非阻塞
        observerList.forEach(o -> o.notify(message));

        // new Thread()
        new Thread(() -> {
            observerList.forEach(o -> o.notify(message));
        }).start();

        // 线程池
        ThreadPoolUtil.getThreadPool(10).
                execute(() -> observerList.forEach(o -> o.notify(message)));

    }
}
