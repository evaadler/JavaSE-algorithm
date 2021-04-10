package designpattern.strategy;

/**
 * Duck
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public abstract class Duck {

    FlyBehaivor flyBehaivor;
    // 其他属性，策略接口

    public Duck() {
    }

    public void quack(){
        System.out.println("鸭子嘎嘎叫");
    }

    public void swim(){
        System.out.println("鸭子会游泳");
    }

    public abstract void display();
}
