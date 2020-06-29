package java8;

import cleancode.old.fitness.StringUtil;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * MethodRefTest 方法引用的使用
 *
 * 1。使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2。方法引用，本质上就是 Lambda 表达式，而 Lambda 表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例。
 * 3. 使用格式：类
 * @author Alicia
 * @description
 * @date 2020/6/20
 */
public class MethodRefTest {


    /**
     * 情况一：对象::实例方法名
     * Consumer 中的 void accept(T t)
     * PrintStream 中的 void println(T t)
     */
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京欢迎你");

        System.out.println("**************************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;//不用写括号（参数由函数式接口中的抽象方法决定）
        con2 = System.out::println;
        con2.accept("ddddd");
    }

    /**
     * Supplier
     * 类：：静态方法名
     */
    public void test2() {
        Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
        // lambda 体中现成的实现（代替lambda表达式）
        com = Integer::compare;
    }

    /**
     * 比较两个字符串是不是一样
     * 类：：实例方法名
     */
    @Test
    public void test3(){
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("s1", "s2"));

        predicate = String::equals;
        System.out.println(predicate.test("s1", "s1"));
    }

    // 构造器引用 -》 供给型接口（无参数，有返回值）可用来创建对象
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        // 构造器引用方式(无参数)
        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup2.get();
        System.out.println(emp);
    }

    // 构造器引用(带参数)
    @Test
    public void testOneParamConstruct(){

        Function<Integer, Employee> fun = (id) -> new Employee(id);
        // ❓ 由于Lambda体中只有一个new，可以用构造器引用完成这个事
        Function<Integer, Employee> fun2 = Employee::new;
    }


    /**
     * 数组引用：
     */
    @Test
    public void test7() {
        Function<Integer, String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        fun = String[]::new;
        strs = fun.apply(20);
        System.out.println(strs.length);
    }


}
