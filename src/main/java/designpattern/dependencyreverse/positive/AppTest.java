package designpattern.dependencyreverse.positive;

/**
 * AppTest
 *
 * @author Alicia
 * @description
 * @date 2021/8/8
 */
interface Animial{
    public void eat();
}

class Person{
    public void feed(Animial animial) {
        System.out.println("开始喂养...");
        animial.eat();
    }
}

class Dog implements Animial{
    @Override
    public void eat(){
        System.out.println("狗啃骨头");
    }
}
// ========================
// 变化来了，客户端不仅仅需要喂狗，还需要喂猫！
// 客户端自己定义了一个猫类

class Cat implements Animial{
    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Person p = new Person();
        Dog d = new Dog();
        Cat c = new Cat();

        p.feed(d);
        p.feed(c);
    }
}

// 此时，这种代码违反了依赖倒置，因为，每当下层变动时，上层都要跟着一起变动
// 我们希望的是，当下层新增一个动物时，上层应该"不知道"，上层代码应该不用改动   


