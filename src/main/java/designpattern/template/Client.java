package designpattern.template;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class Client {
    public static void main(String[] args) {
        // 制作红豆豆浆
        System.out.println("---制作红豆豆浆---");
        SoyaMilk redMilk = new RedBeatSoyaMilk();
        redMilk.make();
        System.out.println("---制作花生豆浆---");
        SoyaMilk peanutMilk = new PeanutSoyaMilk();
        redMilk.make();
    }
}
