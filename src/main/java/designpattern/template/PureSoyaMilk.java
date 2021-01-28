package designpattern.template;

/**
 * PureSoyaMilk
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class PureSoyaMilk extends SoyaMilk{

    @Override
    void addCondiments() {

    }

    @Override
    boolean customeWantCondiments() {
        return false;
    }
}
