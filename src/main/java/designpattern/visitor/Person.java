package designpattern.visitor;

/**
 * Person
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public abstract class Person {
    public abstract void accept(Action action);
}
