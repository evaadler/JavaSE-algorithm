package designpattern.decorator;

/**
 * Milk
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛奶 ");
        setPrice(2f);
    }
}
