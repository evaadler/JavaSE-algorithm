package designpattern.singleton;

/**
 * SingletonThreadNotSafe 懒汉式 同步代码块-线程不安全
 *
 * @author Alicia
 * @description
 * @date 2021/1/15
 */
public class SingletonDoubleCheck {
    private static SingletonDoubleCheck singletonThreadNotSafe;

    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance() {

            if (singletonThreadNotSafe == null){
                synchronized (SingletonDoubleCheck.class) {
                    if (singletonThreadNotSafe == null) {
                        singletonThreadNotSafe = new SingletonDoubleCheck();
                    }
                }
            }

        return singletonThreadNotSafe;

    }

    public static void main(String[] args) {
        SingletonDoubleCheck instance1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck instance2 = SingletonDoubleCheck.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
