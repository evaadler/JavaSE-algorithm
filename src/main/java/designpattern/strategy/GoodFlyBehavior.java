package designpattern.strategy;

/**
 * GoodFlyBehavior
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public class GoodFlyBehavior implements FlyBehaivor{
    @Override
    public void fly() {
        System.out.println("飞翔技术高超~");
    }
}
