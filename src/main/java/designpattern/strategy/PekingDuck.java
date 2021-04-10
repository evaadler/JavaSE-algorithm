package designpattern.strategy;

/**
 * PekingDuck
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public class PekingDuck extends Duck{

    public PekingDuck() {
        flyBehaivor = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭子");
    }


}
