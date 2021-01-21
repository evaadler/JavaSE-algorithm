package designpattern.decorator;

import java.io.PipedReader;

/**
 * Drink
 *
 * @author Alicia
 * @description
 * @date 2021/1/21
 */
public abstract class Drink {
    private String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
