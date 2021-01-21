package designpattern.decorator;

/**
 * Coffee
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
