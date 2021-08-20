package base;

/**
 * Foo 类的实例化执行顺序
 * 1。 执行静态块
 * 2。 执行构造代码块（随构造器，gou zao qi）
 * 3。 执行构造器
 * 注意：⚠️
 *  类中的实例成员，等价于构造代码块。也就是说，构造代码块该执行的时候，也就回执行实例成员的代码
 *  类中的静态成员，等价于静态块。也就是说，静态块该执行的时候，也就回执行实例成员的代码
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class Foo {
    static {
        System.out.println("1");
    }

    // 构造快
    {
        System.out.println("2");
    }

    public Foo(){
        System.out.println("3");
    }

    public static void main(String[] args) {
        new Foo();
        new Foo();
    }
}
