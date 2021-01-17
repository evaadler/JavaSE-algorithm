package designpattern.factory.absfactory.pizza;

/**
 * CheesePizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪");
        System.out.println("给伦敦奶酪披萨准备原材料");
    }
}
