package designpattern.prototype;

/**
 * Sheep
 *
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
public class Sheep {
    private String name;
    private int age;
    private String color;
    public Sheep(String name, int age ){
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
