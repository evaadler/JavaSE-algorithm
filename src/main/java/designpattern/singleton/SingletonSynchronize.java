package designpattern.singleton;

/**
 * SingletonThreadNotSafe 懒汉式-线程不安全
 *
 * @author Alicia
 * @description
 * @date 2021/1/15
 */
public class SingletonSynchronize {
    private static SingletonSynchronize singletonThreadNotSafe;

    private SingletonSynchronize(){}

    public static synchronized SingletonSynchronize getInstance() {
        if (singletonThreadNotSafe == null){
            singletonThreadNotSafe = new SingletonSynchronize();
        }
        return singletonThreadNotSafe;

    }

    public static void main(String[] args) {
        SingletonSynchronize instance1 = SingletonSynchronize.getInstance();
        SingletonSynchronize instance2 = SingletonSynchronize.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
