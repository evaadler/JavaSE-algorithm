package designpattern.visitor;

/**
 * Woman
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
