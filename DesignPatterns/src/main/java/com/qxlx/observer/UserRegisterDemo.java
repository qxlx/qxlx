package com.qxlx.observer;

/**
 * @author qxlx
 * @date 2024/4/13 22:32
 */
public class UserRegisterDemo {

    public static void main(String[] args) {
        UserSendEmailObserver userSendEmailObserver = new UserSendEmailObserver();
        UserWaSendObserver userWaSendObserver = new UserWaSendObserver();
        ConcreteSubject concreteSubject = new ConcreteSubject();

        concreteSubject.registerObserver(userSendEmailObserver);
        concreteSubject.registerObserver(userWaSendObserver);

        concreteSubject.notifyObservers("register");
    }

}
