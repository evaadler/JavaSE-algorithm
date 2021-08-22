package designpattern.factory.simplefactory;

/**
 * AppTest 这种设计十分脆弱，因为只要作者修改了具体产品的类名，那么
 * 客户端代码，也要随之一起改变。这样服务器端代码，和客户端代码就是耦合的@
 * ❤我们希望的效果是：无论服务器端代码如何修改，客户端代码都应该不知道，不用修改客户端代码
 *
 * 简单工厂的优点：
 * 1. 把决堤
 * @author Alicia
 * @description
 * @date 2021/8/22
 */
public class AppTest {
    public static void main(String[] args) {
//        Food f = new Hamburger();
//        f.eat();

        Food f = FoodFactory.getFood(1);
        f.eat();
    }

}

/**
 * 抽象产品
 */
interface Food{
    void eat();
}

/**
 * 这个工厂也可以称之为接口：任何下层给上层暴露出来的方法都可以称之为接口
 */
class FoodFactory{
    public static Food getFood(int n){
        Food food = null;
        switch (n){
            case 1:
                food = new Hamburger();
                break;
            case 2:
                food = new RichNoodle();
                break;
            default:
        }
        return food;
    }
}

/**
 * 具体产品
 */
class Hamburger implements Food{

    @Override
    public void eat() {
        System.out.println("吃汉堡包！");
    }
}

class RichNoodle implements Food{

    @Override
    public void eat() {
        System.out.println("吃米线");
    }
}
