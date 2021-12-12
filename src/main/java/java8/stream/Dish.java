package java8.stream;

/**
 * Dish
 *
 * @author Alicia
 * @description
 * @date 2021/9/1
 */
public class Dish {


    private int calories;
    private String name;
    private boolean b;
    private Type type;

    public Dish(String name, boolean b, int calories, Type type){
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.b = b;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum Type {
        /**
         * meat
         */
        MEAT,
        OTHER
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public Type getType() {
        return type;
    }


}
