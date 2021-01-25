package designpattern.facade;

/**
 * DVDPlayer
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class DVDPlayer {

    private static DVDPlayer dvdPlayer = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return dvdPlayer;
    }

    public void on() {
    }

    public void off() {
    }
}
