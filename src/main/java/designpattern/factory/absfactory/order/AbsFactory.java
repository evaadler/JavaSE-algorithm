package designpattern.factory.absfactory.order;

import designpattern.factory.absfactory.pizza.Pizza;

/**
 * AbsFactory
 *
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
// 一个抽象工厂模式的抽象层(接口)
public interface AbsFactory {
    // 让下面的工厂子类来具体实现
     Pizza createPizza(String orderType);
}
