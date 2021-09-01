package java8;

import com.sun.xml.internal.ws.policy.ComplexAssertion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * MethodReference
 *
 * @author Alicia
 * @description
 * @date 2021/8/31
 */
public class MethodReference {

    public static void main(String[] args) {
        Consumer<String> consumer = (s)-> System.out.println(s);
        useConsumer(consumer, "Hello Alex");

        /**
         * 方法引用的实现方式：这是如何推导的呢？
         * System.out::println 和 consumer 的函数描述是一样的（只有一个入参，没有任何返回值），所以可以这里用
         */
        useConsumer(System.out::println, "Hello fifi");

        List<Apple> list = Arrays.asList(new Apple("Green", 110), new Apple("red", 123), new Apple("abc", 123));
        System.out.println(list);
        list.sort((a1, a2)->{return a1.getColor().compareTo(a2.getColor());});
        list.sort((a1, a2)->a1.getColor().compareTo(a2.getColor()));
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);

        list.stream().forEach(a-> System.out.println(a));
        System.out.println("=====================");
        list.stream().forEach(System.out::println);

        // 方法的引用赋给一个变量；可以想象成f(x)先定义数学公式，再代入参数
        Function<String, Integer> f = Integer::parseInt;
        f.apply("123");

        String s2 = new String("hello");
        Function<Integer, Character> f3 = s2::charAt;
        Character c3 = f3.apply(4);
        System.out.println(c3);


        System.out.println("==========BiFunction==========");
        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character c = f2.apply("hello", 2);
        System.out.println(c);

        System.out.println("==========Supplier==========");
        Supplier<String> supplier = String::new;
        String s = supplier.get();
        System.out.println(s);

        BiFunction<String, Long, Apple> appleFunction = Apple::new;
        Apple apple = appleFunction.apply("red", 100L);
        System.out.println(apple);

        //ThreeFunction<String, Long, String, ComplexApple> treeFunction = Complex::new;
        //treeFunction.apply("Green",123L, "Fushi");

        list.sort(Comparator.comparing(Apple::getColor));

        String sss = null;
        //Objects.requireNonNull(sss);
        sss.getBytes();

    }

    private static <T> void useConsumer(Consumer<T> consumer, T t){
        consumer.accept(t);
        consumer.accept(t);
    }
}
