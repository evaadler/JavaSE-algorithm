package designpattern.command;

/**
 * 没有任何命令，空执行：用于初始化每个按钮，当调用空命令时，对象什么都不做
 * 其实，这也是一种设计模式，可以省掉对空的判断
 *
 * @author Alicia
 * @description
 * @date 2021/1/28
 */
public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("执行撤销按钮");
    }

    @Override
    public void undo() {
        System.out.println("撤销撤销按钮");
    }
}
