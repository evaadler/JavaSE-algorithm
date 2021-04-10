package designpattern.strategy;

/**
 * GoodFlyBehavior
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public class NoFlyBehavior implements FlyBehaivor{
    @Override
    public void fly() {
        System.out.println("不会飞呀~");
    }
}
