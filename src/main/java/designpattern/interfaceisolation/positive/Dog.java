package designpattern.interfaceisolation.positive;

import designpattern.interfaceisolation.negative.Animal;

/**
 * Dog
 *
 * @author Alicia
 * @description
 * @date 2021/8/8
 */
public class Dog implements Eatable, Swimable {
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }

}
