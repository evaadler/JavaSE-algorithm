package enumclass;

/**
 * 通过饿汉模式实现单例
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}

    public static SingletonHungry getInstance() {
        return instance;
    }
}
