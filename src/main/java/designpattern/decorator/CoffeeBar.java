package designpattern.decorator;

/**
 * CoffeeBar
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public class CoffeeBar {

    public static void main(String[] args) {
        // 1. 点一份LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1="+order.cost());
        System.out.println("描述"+order.getDes());

        // 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用="+order.cost());
        System.out.println("order 加入一份牛奶 描述="+order.getDes());

        // 3. 加入巧克力
    }
}
