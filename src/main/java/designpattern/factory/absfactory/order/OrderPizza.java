package designpattern.factory.absfactory.order;

import designpattern.factory.absfactory.pizza.Pizza;

import javax.xml.stream.FactoryConfigurationError;
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
public  class OrderPizza {


    AbsFactory factory;


    public  OrderPizza(){
        String orderType = "";
        Pizza pizza = null;

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
