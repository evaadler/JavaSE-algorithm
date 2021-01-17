package designpattern.factory.factorymethod.pizza;

/**
 * Pizza
 *
 * @author Alicia
 * @description
 * @date 2021/1/16
 */
public abstract class Pizza {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare() ;

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
