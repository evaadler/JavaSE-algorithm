package designpattern.factory.absfactory.order;

import designpattern.factory.absfactory.pizza.LDCheesePizza;
import designpattern.factory.absfactory.pizza.LDGreekPizza;
import designpattern.factory.absfactory.pizza.LDPepperPizza;
import designpattern.factory.absfactory.pizza.Pizza;

/**
 * LDOrderPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class LDOrderPizza implements AbsFactory {



    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equalsIgnoreCase("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equalsIgnoreCase("greek")){
            pizza = new LDGreekPizza();
        }else if (orderType.equalsIgnoreCase("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
