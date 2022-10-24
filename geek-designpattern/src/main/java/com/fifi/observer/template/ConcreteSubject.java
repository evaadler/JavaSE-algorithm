package com.fifi.observer.template;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject
 *
 * @author Alicia
 * @description
 * @date 2022/10/24
 */
public class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        for (Observer observer : observers){
            observer.update(message);
        }
    }
}
