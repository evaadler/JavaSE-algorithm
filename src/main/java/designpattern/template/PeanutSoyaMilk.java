package designpattern.template;

/**
 * PeanutSoyaMilk
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class PeanutSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("加入上好的花生");
    }
}
