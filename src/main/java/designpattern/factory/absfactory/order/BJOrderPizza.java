package designpattern.factory.absfactory.order;

import designpattern.factory.absfactory.pizza.BJCheesePizza;
import designpattern.factory.absfactory.pizza.BJGreekPizza;
import designpattern.factory.absfactory.pizza.BJPepperPizza;
import designpattern.factory.absfactory.pizza.Pizza;

/**
 * BJOrderPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class BJOrderPizza implements AbsFactory {



    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equalsIgnoreCase("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equalsIgnoreCase("greek")){
            pizza = new BJGreekPizza();
        }else if (orderType.equalsIgnoreCase("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;

    }

}
