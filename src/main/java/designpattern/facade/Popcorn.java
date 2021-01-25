package designpattern.facade;

/**
 * Popcorn
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Popcorn {

    public static Popcorn popcorn = new Popcorn();

    public static Popcorn getInstance(){
        return popcorn;
    }

    public void on() {
    }

    public void pop() {
    }

    public void off() {
    }
}
