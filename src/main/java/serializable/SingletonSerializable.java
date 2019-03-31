package serializable;

import java.io.*;

// 单例序列化实例
public class SingletonSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.serila"));
        Singleton p = Singleton.getInstance();
        oos.writeObject(p);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.serial"));
        Singleton p1 = (Singleton) ois.readObject();
        System.out.println(p == p);
    }
}

// 饿汉
final class Singleton implements Serializable{
    private Singleton(){}

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    // 保证反序列化对象依然正常
    private Object readResolve(){
        return INSTANCE;
    }
}
