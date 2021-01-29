package designpattern.visitor;

/**
 * Man
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
