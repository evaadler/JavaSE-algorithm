package designpattern.decorator;

/**
 * Decorato
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink obj){
        this.drink = obj; //  组合
    }


    @Override
    public float cost() {
        return getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        return super.getDes()+" " + super.getPrice()+" && "+drink.getDes();
    }
}
