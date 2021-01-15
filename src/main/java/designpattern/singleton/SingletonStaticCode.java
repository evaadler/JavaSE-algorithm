package designpattern.singleton;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import enumclass.SingletonInnerStatic;

/**
 * SingletonStaticConstant 静态代码块
 *
 * @author Alicia
 * @description
 * @date 2021/1/14
 */
public class SingletonStaticCode {
    static{
        instance = new SingletonStaticCode();
    }

    // 1. 构造器私有化，外不能new
    private SingletonStaticCode(){

    }

    // 2. 本类内部创建对象实例
    private static SingletonStaticCode instance ;

    // 3. 提供一个公有的静态方法，返回实例对象
    public static SingletonStaticCode getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        SingletonStaticCode instance1 = SingletonStaticCode.getInstance();
        SingletonStaticCode instance2 = SingletonStaticCode.getInstance();
        System.out.println(instance1== instance2);
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
