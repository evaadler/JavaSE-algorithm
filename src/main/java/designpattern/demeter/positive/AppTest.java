package designpattern.demeter.positive;

/**
 * Computer
 *
 * @author Alicia
 * @description
 * @date 2021/8/21
 */
class Computer {
    private void saveData(){
        System.out.println("保存数据");
    }

    private void killProcess(){
        System.out.println("关闭程序");
    }

    private void closeScreen(){
        System.out.println("关闭屏幕");
    }

    private void poweroff(){
        System.out.println("断电");
    }

    public void shutDown(){
        saveData();
        killProcess();
        closeScreen();
        poweroff();
    }
}

class Person{

    /**
     * // 一个类的对象作为另一个类的字段：关联关系
     *     // 人关联电脑
     */
    private Computer computer = new Computer();

    /**
     * 此时 person 对于 compuer 的细节知道太多了，对于person 而言，最好只需要知道
     * 关机按钮就好了，不需要知道如何保存数据，如果关闭进程等细节。这样的话，代码的复杂度提升
     */
    public void shutdownComputer(){
        computer.shutDown();
    }
}

public class AppTest {
    public static void main(String[] args) {

    }
}
