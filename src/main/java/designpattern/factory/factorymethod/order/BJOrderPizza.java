package designpattern.factory.factorymethod.order;

import designpattern.factory.factorymethod.pizza.BJCheesePizza;
import designpattern.factory.factorymethod.pizza.BJGreekPizza;
import designpattern.factory.factorymethod.pizza.BJPepperPizza;
import designpattern.factory.factorymethod.pizza.Pizza;

/**
 * BJOrderPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class BJOrderPizza extends OrderPizza{



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
