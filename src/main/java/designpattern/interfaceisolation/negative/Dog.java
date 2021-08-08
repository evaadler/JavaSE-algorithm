package designpattern.interfaceisolation.negative;

/**
 * Dog
 *
 * @author Alicia
 * @description
 * @date 2021/8/8
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }

    @Override
    public void fly() {
        throw new RuntimeException("你行你来！你来飞");
    }
}
