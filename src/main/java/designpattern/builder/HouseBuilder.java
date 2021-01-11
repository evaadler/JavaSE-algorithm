package designpattern.builder;

/**
 * HouseBuilder
 *
 * @author Alicia
 * @description
 * @date 2021/1/11
 */
public abstract class HouseBuilder {

    protected House house = new House();

    // 将建造的流程写好，抽象的方法
    // 打地基
    public abstract void buildBasic();
    // 盖房
    public abstract void buildWalls();
    // 封顶
    public abstract void roofed();

    // 建造房子好，将产品（房子）返回
    public House build(){
        return house;
    }
}
