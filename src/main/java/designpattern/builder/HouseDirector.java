package designpattern.builder;

/**
 * HouseDirector
 *
 * @author Alicia
 * @description
 * @date 2021/1/11
 */
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    // 构造器传入 houseBuilder
    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    // 通过setter传入 houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.build();
    }

}
