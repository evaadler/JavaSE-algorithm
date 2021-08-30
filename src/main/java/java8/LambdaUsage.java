package java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * LambdaUsage
 *
 * @author Alicia
 * @description
 * @date 2021/8/26
 */
public class LambdaUsage {
    @FunctionalInterface
    public interface Adder{

        int add(int a, int b);
    }


    public interface SmartAdder extends Adder{
        long add(long a, long b);
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("jey");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("jey");
            }
        };

        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));
        List<Apple> greenList = filter(list, (apple -> apple.getColor().equals("green")));
        System.out.println(greenList);

        List<Apple> weightList = filterByWeight(list, (w)-> w>100);
        System.out.println(weightList);

        List<Apple> result3 = filterByBiPredicate(list, (s,w)-> s.equals("green")&&w>100);
        System.out.println(result3);
        System.out.println("-----consumer--------start");
        //consumer
        simpleTestConsumer(list, a-> System.out.println(a));

        //simpleBiConsumer("xxx", list, (a,s)-> System.out.println(s+a.getColor()+":weight=>"a.getWeight()));

        System.out.println("\n-------function------start");

        String result4 = testFunction(new Apple("yellow", 100), (a)->a.toString());
        System.out.println(result4);

        IntFunction<Double> f = i->i*100.0d;
        double result5 = f.apply(10);
        System.out.println(result5);

        System.out.println("\n-------function------start");
        Apple a = testBiFunction("Blue", 130L, (s,w)->new Apple(s,w));
    }

    public static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a : source){
            if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a : source){
            if (predicate.test(a.getWidth())){
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a : source){
            if (predicate.test(a.getColor(), (long)a.getWidth())){
                result.add(a);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumers){
        List<Apple> result = new ArrayList<>();
        for (Apple e : source){
            consumers.accept(e);
        }
    }

    private static void simpleBiConsumer(List<Apple> source, BiConsumer<Apple, String> consumers){
        List<Apple> result = new ArrayList<>();
        for (Apple e : source){
            consumers.accept(e, e.getColor());
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun){
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> fun){
        return null;
    }
}
