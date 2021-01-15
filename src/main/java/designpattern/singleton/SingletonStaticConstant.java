package designpattern.singleton;

/**
 * SingletonStaticConstant 静态变量
 *
 * @author Alicia
 * @description
 * @date 2021/1/14
 */
public class SingletonStaticConstant {
    // 1. 构造器私有化，外部能new
    private SingletonStaticConstant(){

    }

    // 2. 本类内部创建对象实例
    private final static SingletonStaticConstant instance = new SingletonStaticConstant();

    // 3. 提供一个公有的静态方法，返回实例对象
    public static SingletonStaticConstant getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        SingletonStaticConstant instance1 = SingletonStaticConstant.getInstance();
        SingletonStaticConstant instance2 = SingletonStaticConstant.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
