package designpattern.flyweight;

/**
 * User
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
