package designpattern.visitor;

/**
 * Fail
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人评价说失败了");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人评价说失败了");
    }
}
