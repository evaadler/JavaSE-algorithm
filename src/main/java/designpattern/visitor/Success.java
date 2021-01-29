package designpattern.visitor;

/**
 * Success
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人说成功了");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人评价说成功了");
    }
}
