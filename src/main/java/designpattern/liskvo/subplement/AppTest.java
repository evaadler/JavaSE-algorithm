package designpattern.liskvo.subplement;

/**
 * 方法重写：
 *  在子类和父类中，出现了返回类型相同、方法名相同、方法参数相同的方法时，构成方法重写
 *
 * 方法重写的两个限制：
 *  1. 子类重写父类的方法时，子类方法的访问修饰符不能比父类的更严格
 *  2. 子类重写父类的方法时，子类方法不能抛出比父类更多的异常
 *
 * @author Alicia
 * @description
 * @date 2021/8/21
 */
public class AppTest {
}

class Fu{
    public void f1(){

    }

}

class Zi extends Fu{
    public void f1(){

    }
}
