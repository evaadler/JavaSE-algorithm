package designpattern.builder;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/11
 */
public class Client {

    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        houseDirector.constructHouse();
    }
}
