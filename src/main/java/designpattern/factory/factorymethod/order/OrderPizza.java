package designpattern.factory.factorymethod.order;

import designpattern.factory.factorymethod.pizza.Pizza;

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
public abstract class OrderPizza {


    //SimpleFactory simpleFactory = null;
    Pizza pizza = null;

    public  OrderPizza(){
        String orderType = "";


        do {
            System.out.println("披萨种类：");
            orderType = getType();
            pizza = createPizza(orderType);

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

    public  abstract Pizza createPizza(String orderType);

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
