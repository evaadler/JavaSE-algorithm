package designpattern.prototype.improve;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式完成对象的创建");
        Sheep sheep = new Sheep("tom", 1, "dd");
        Sheep sheep1 = (Sheep)sheep.clone(); // 克隆
        System.out.println(sheep);
        System.out.println(sheep1);
    }
}
