package designpattern.factory.simplefactory.pizzastore.order;

/**
 * PizzaStore
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
        System.out.println("退出程序");
    }
}
