package designpattern.singleton;

/**
 * SingletonStaticConstant 静态内部类
 *
 * @author Alicia
 * @description
 * @date 2021/1/14
 */
public class SingletonStaticInner {

    // 1. 构造器私有化，外不能new
    private SingletonStaticInner(){

    }

    // 2. 本类内部创建对象实例
    private static class SingletonStaticInnerInstance {
        private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
    }

    // 3. 提供一个公有的静态方法，返回实例对象
    public static SingletonStaticInner getInstance(){
        return SingletonStaticInnerInstance.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonStaticInner instance1 = SingletonStaticInner.getInstance();
        SingletonStaticInner instance2 = SingletonStaticInner.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
