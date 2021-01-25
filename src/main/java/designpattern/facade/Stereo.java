package designpattern.facade;

/**
 * Stereo
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Stereo {
    private static Stereo stereo = new Stereo();
    
    public static Stereo getInstance(){
        return stereo;
    }

    public void on() {
    }

    public void off() {
    }
}
