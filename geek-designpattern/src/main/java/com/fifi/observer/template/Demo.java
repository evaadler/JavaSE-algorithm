package com.fifi.observer.template;

/**
 * Demo
 *
 * @author Alicia
 * @description
 * @date 2022/10/24
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObserver(new Message());
    }
}
