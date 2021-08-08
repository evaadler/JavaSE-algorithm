package designpattern.interfaceisolation.negative;

/**
 * Bird
 *
 * @author Alicia
 * @description
 * @date 2021/8/8
 */
public class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("鸟吃虫子");
    }

    @Override
    public void swim() {
        throw new RuntimeException("you can you up!");
    }

    @Override
    public void fly() {
        System.out.println("我飞!");
    }
}
