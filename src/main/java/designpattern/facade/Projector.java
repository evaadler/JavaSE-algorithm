package designpattern.facade;

/**
 * Projector
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Projector {
    
    private static Projector projector = new Projector();

    public static Projector getInstance() {
        return projector;
    }

    public void on() {
    }

    public void off() {
    }
}
