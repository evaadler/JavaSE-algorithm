package designpattern.factory.absfactory;

/**
 * 針對工廠方法的問題，當產品等級有多個時（食物，飲料，甜品。。），工廠類就會跟多！
 */

public class AppTest {
    public static void main(String[] args) {
        Factory ff = new HamburgerFactory();
       // Business.taste(new RiceNoodleFactory());

        Business.taste(new BaojiFactory());
    }
}

class HamburgerFactory implements Factory{
    @Override
    public Food getFood() {
        return new Hamburger();
    }

    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class RiceNoodleFactory implements Factory{
    @Override
    public Food getFood() {
        return new RichNoodle();
    }

    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}

//業務裡面接的是工廠類型
class Business{
    public static void taste(Factory ff){
        Food f = ff.getFood();
        Drink d = ff.getDrink();
        System.out.println("评委1，品尝");
        f.eat();
        d.drink();

        Food f2 = ff.getFood();
        Drink d2 = ff.getDrink();
        System.out.println("评委2，品尝");
        f2.eat();
        d2.drink();

        Food f3 = ff.getFood();
        Drink d3 = ff.getDrink();
        System.out.println("评委3，品尝");
        f3.eat();
        d3.drink();

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
interface Factory{
    /**
     * getFood
     * @return FOOD
     */
     Food getFood();
     Drink getDrink();
}

interface Drink{
    public void drink();
}

interface DrinkFactory{
    public Drink getDrink();
}

class Cola implements Drink{
    @Override
    public void drink() {
        System.out.println("可口可樂，你值得擁有！");
    }
}

class ColaFactory implements DrinkFactory{
    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class IcePeak implements Drink{
    @Override
    public void drink() {
        System.out.println("從小就喝他");
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
//==========扩展产品

class Lp implements Food{

    @Override
    public void eat() {
        System.out.println("宝鸡擀面皮");
    }
}
class Fenda implements Drink{

    @Override
    public void drink() {
        System.out.println("气泡芬达，爽");
    }
}

//==========扩展工厂
class BaojiFactory implements Factory{

    @Override
    public Food getFood() {
        return new Lp();
    }

    @Override
    public Drink getDrink() {
        return new Fenda();
    }
}