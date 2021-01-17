package designpattern.factory.simplefactory.pizzastore.order;

import com.apple.laf.AquaGroupBorder;
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

    public OrderPizza(SimpleFactory factory){
        setFactory(factory);
    }

    SimpleFactory simpleFactory = null;
    Pizza pizza = null;

    public void setFactory(SimpleFactory factory){
        String orderType = "";
        this.simpleFactory = factory;

        do {
            System.out.println("披萨种类：");
            orderType = getType();
            pizza = factory.createPizza(orderType);

            if (pizza!=null){
                pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            }else {
                System.out.println("披萨订购失败");
                break;
            }
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
