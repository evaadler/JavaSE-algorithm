package designpattern.flyweight;

/**
 * ConcreteWebSite
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class ConcreteWebSite extends WebSite{

    private String type = "";

    public ConcreteWebSite(String type){
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为："+type+" 在使用中，使用者是:"+user.getName());
    }
}
