package designpattern.facade;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.ready();;
        facade.play();;


        facade.close();
    }
}
