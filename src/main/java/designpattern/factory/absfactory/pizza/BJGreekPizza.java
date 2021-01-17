package designpattern.factory.absfactory.pizza;

/**
 * GreekPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public class BJGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的奶酪");
        System.out.println("给北京奶酪披萨准备原材料");
    }
}
