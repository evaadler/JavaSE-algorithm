package designpattern.flyweight;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * WebSiteFactory  网站工厂类，根据需要返回一个网站
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class WebSiteFactory {
    // 集合，充当池的作用
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    // 根据网站类型，返回一个网站，如果没有就创建一个网站，并放入到池中，并返回
    public WebSite getWebSiteFactory(String type) {

        if (!pool.containsKey(type)){
            // 就创建一个网站，并放入池中
            pool.put(type, new ConcreteWebSite(type));
        }

        return pool.get(type);
    }

    // 获取网站分类总数（池中有多少个网站类型）
    public int getWebSiteCount(){
        return pool.size();
    }
}
