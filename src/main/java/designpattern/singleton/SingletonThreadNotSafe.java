package designpattern.singleton;

/**
 * SingletonThreadNotSafe 懒汉式-线程不安全
 *
 * @author Alicia
 * @description
 * @date 2021/1/15
 */
public class SingletonThreadNotSafe {
    private static SingletonThreadNotSafe singletonThreadNotSafe;

    private SingletonThreadNotSafe(){}

    public static SingletonThreadNotSafe getInstance() {
        if (singletonThreadNotSafe == null){
            singletonThreadNotSafe = new SingletonThreadNotSafe();
        }
        return singletonThreadNotSafe;

    }

    public static void main(String[] args) {
        SingletonThreadNotSafe instance1 = SingletonThreadNotSafe.getInstance();
        SingletonThreadNotSafe instance2 = SingletonThreadNotSafe.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
