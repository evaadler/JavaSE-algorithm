package designpattern.iterator;

/**
 * Department 系
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public class Department {
    private String name;
    private String desc;

    public Department(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
