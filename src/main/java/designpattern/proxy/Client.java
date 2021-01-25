package designpattern.proxy;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();
        // 创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象，调用到被代理对象的方法
        // 即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
        proxy.teach();

        System.out.println("接下来是动态代理");
        // 动态代理
        ITeacherDao dao = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        System.out.println("proxyInstance="+dao);
        //com.sun.proxy.$Proxy0 代理对象
        System.out.println("proxyInstanceClass="+dao.getClass());
    }
}
