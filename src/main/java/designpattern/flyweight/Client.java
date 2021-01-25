package designpattern.flyweight;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/25
 */
public class Client {



    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite webSite1 = factory.getWebSiteFactory("新闻");
        User user = new User("jack");
        webSite1.use(user);

        WebSite webSite2 = factory.getWebSiteFactory("博客");
        webSite2.use(new User("smith"));
        WebSite webSite3 = factory.getWebSiteFactory("博客");
        webSite3.use(new User("alice"));

        WebSite webSite4 = factory.getWebSiteFactory("博客");
        webSite4.use(new User("Tom"));

        System.out.println("网站的分类共="+factory.getWebSiteCount());
    }
}
