package designpattern.singleton;

/**
 * SingletonThreadNotSafe 懒汉式 双重检查锁
 *
 * @author Alicia
 * @description
 * @date 2021/1/15
 */
public class SingletonSynchronizeCode {
    private static SingletonSynchronizeCode singletonThreadNotSafe;

    private SingletonSynchronizeCode(){}

    public static SingletonSynchronizeCode getInstance() {

            if (singletonThreadNotSafe == null){
                synchronized (SingletonSynchronizeCode.class) {
                    singletonThreadNotSafe = new SingletonSynchronizeCode();
                }
            }

        return singletonThreadNotSafe;

    }

    public static void main(String[] args) {
        SingletonSynchronizeCode instance1 = SingletonSynchronizeCode.getInstance();
        SingletonSynchronizeCode instance2 = SingletonSynchronizeCode.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
