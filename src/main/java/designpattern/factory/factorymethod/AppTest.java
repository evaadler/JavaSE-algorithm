package designpattern.factory.factorymethod;

/**
 * AppTest 这种设计十分脆弱，因为只要作者修改了具体产品的类名，那么
 * 客户端代码，也要随之一起改变。这样服务器端代码，和客户端代码就是耦合的@
 * ❤我们希望的效果是：无论服务器端代码如何修改，客户端代码都应该不知道，不用修改客户端代码
 *
 * 简单工厂的优点：
 * 1. 把具體的產品類型，從客戶端代碼中，解耦出來
 * 2. 服務器端，如果修改了具體產品的類名，客戶端也不知道
 * 這便符合了"面向接口編程"的思想，也符合了迪米特法則
 *
 * 缺點：
 * 1.客戶端不得不死記硬背哪些常量與具體產品的映射關係，比如：1對應漢堡 2對應米線
 * 2. 如果具體產品特別多，則簡單工廠，就會變得十分臃腫。比如有100個具體產品，則需要在簡單工廠的switch中寫出100個case
 * 3. 最重要的是，變化來了，客戶端需要擴展具體產品的時候，是必要的修改簡單工廠中的代碼，便違反了開閉原則
 * @author Alicia
 * @description
 * @date 2021/8/22
 */
public class AppTest {
    public static void main(String[] args) {
//        Food f = new Hamburger();
//        f.eat();

        FoodFactory ff = new HamburgerFactory();
        Business.taste(new RiceNoodleFactory());
    }

}

class HamburgerFactory implements FoodFactory{
    @Override
    public Food getFood() {
        return new Hamburger();
    }
}

class RiceNoodleFactory implements FoodFactory{
    @Override
    public Food getFood() {
        return new RichNoodle();
    }
}

//業務裡面接的是工廠類型
class Business{
    public static void taste(FoodFactory ff){
        Food f = ff.getFood();
        System.out.println("评委1，品尝");
        f.eat();

        Food f2 = ff.getFood();
        System.out.println("评委2，品尝");
        f2.eat();

        Food f3 = ff.getFood();
        System.out.println("评委3，品尝");
        f3.eat();

    }
}

/**
 * 抽象产品
 */
interface Food{
    /**
     * EAT
     */
    void eat();
}

/**
 * 这个工厂也可以称之为接口：任何下层给上层暴露出来的方法都可以称之为接口
 */
interface FoodFactory{
    /**
     * getFood
     * @return FOOD
     */
     Food getFood();
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
