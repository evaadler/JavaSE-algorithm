package designpattern.strategy;

/**
 * Toy
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public class Toy extends Duck{
    public Toy() {
        flyBehaivor = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭子");
    }
}
