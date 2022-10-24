package com.fifi.observer.template;

/**
 * ConcreteObserverOne
 *
 * @author Alicia
 * @description
 * @date 2022/10/24
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne is notified...");
    }
}
