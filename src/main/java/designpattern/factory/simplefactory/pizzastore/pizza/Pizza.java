package designpattern.factory.simplefactory.pizzastore.pizza;

/**
 * Pizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public class Pizza {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println("给"+name+"准备原材料");
    }

    public void bake() {
        System.out.println(name + "baking");
    }

    public void cut() {
        System.out.println(name + "cutting");
    }

    public void box() {
        System.out.println(name + "boxing");
    }
}
