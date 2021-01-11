package designpattern.builder;

/**
 * CommonHouse
 *
 * @author Alicia
 * @description
 * @date 2021/1/11
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子建造屋顶");
    }
}
