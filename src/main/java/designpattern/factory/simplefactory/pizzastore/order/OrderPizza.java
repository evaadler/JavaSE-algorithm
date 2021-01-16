package designpattern.factory.simplefactory.pizzastore.order;

import designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * OrderPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public class OrderPizza {

    public OrderPizza(){
        Pizza pizza = null;
        String orderType;
        System.out.println("input pizza 种类：");
        do {
            orderType = getType();
            if (orderType.equalsIgnoreCase("cheese")){
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
            }else if(orderType.equalsIgnoreCase("greek")){
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
            }else{
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    public String getType(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info = "";
        try {
            info = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }
}
