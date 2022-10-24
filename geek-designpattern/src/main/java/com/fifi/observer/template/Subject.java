package com.fifi.observer.template;

/**
 * Subject
 *
 * @author Alicia
 * @description
 * @date 2022/10/24
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
