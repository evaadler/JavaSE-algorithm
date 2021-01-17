package designpattern.factory.absfactory.pizza;

/**
 * PepperPizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/17
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的奶酪");
        System.out.println("给北京胡椒披萨准备原材料");
    }
}
