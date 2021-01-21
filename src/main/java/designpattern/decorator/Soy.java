package designpattern.decorator;

/**
 * Soy
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
