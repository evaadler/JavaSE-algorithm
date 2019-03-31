package enumclass;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.concurrent.atomic.AtomicReference;

// 通过CAS（AtomicReference）实现单例模式
public class SingletonCAS {
    private static final AtomicReference<SingletonCAS> INSTANCE =
            new AtomicReference<SingletonCAS>();

    private SingletonCAS(){}

    public static SingletonCAS getInstance() {
        for(;;){
            SingletonCAS singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new SingletonCAS();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }


}
