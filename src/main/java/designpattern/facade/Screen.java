package designpattern.facade;

/**
 * Screen
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Screen {

    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    public void down() {
    }

    public void up() {
    }
}
