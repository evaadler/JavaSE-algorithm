package enumclass;

// 通过静态内部类模式实现单例
public class SingletonInnerStatic {
    private static class SingletonHolder{
        private static final SingletonInnerStatic INSTANCE = new SingletonInnerStatic();
    }

    private SingletonInnerStatic(){}

    public static final SingletonInnerStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
