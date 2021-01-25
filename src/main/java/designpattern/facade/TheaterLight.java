package designpattern.facade;

/**
 * TheaterLight
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class TheaterLight {
    private static TheaterLight theaterLight = new TheaterLight();

    public static TheaterLight getInstance() {
        return theaterLight;
    }

    public void dim() {
    }

    public void bright() {
    }
}
