package designpattern.factory.factorymethod.order;

import designpattern.factory.factorymethod.pizza.*;

/**
 * LDOrderPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class LDOrderPizza extends OrderPizza {



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
