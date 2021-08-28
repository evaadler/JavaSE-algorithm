package java8;

/**
 * Apple
 *
 * @author Alicia
 * @date 2021/8/22
 */
public class Apple {
    private String color;
    private int width;

    public Apple(String color, int width){
        this.color = color;
        this.width = width;
    }

    public Apple() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", width=" + width +
                '}';
    }
}
