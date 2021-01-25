package designpattern.facade;

/**
 * HomeTheaterFacade
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class HomeTheaterFacade {
    Popcorn popcorn;
    Screen screen ;
    Projector projector;
    Stereo stereo;
    DVDPlayer dvdPlayer ;
    TheaterLight theaterLight ;

    // 构造方法里初始化
    public HomeTheaterFacade(){
        popcorn =  Popcorn.getInstance();
        screen = Screen.getInstance();
        projector =  Projector.getInstance();
         stereo = Stereo.getInstance();
         dvdPlayer = DVDPlayer.getInstance();
         theaterLight = TheaterLight.getInstance();
    }

    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public void play(){

    }

    public void pause(){

    }

    public void end(){
        popcorn.off();
        screen.up(); // 屏幕升起来
        projector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.bright();
    }

    public static void main(String[] args) {

    }

    public void close() {
    }
}
