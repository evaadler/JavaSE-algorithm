package designpattern.factory.simplefactory.pizzastore.order;

import com.sun.scenario.effect.impl.prism.ps.PPSZeroSamplerPeer;
import designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.PepperPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * SimpleFactory
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType){
        Pizza pizza = null;

        if (orderType.equalsIgnoreCase("cheese")){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if(orderType.equalsIgnoreCase("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equalsIgnoreCase("pepper")){
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
