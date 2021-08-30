package java8;




import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * LambdaExpression
 *
 * @author Alicia
 * @description
 * @date 2021/8/24
 */
public class LambdaExpression {

    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(byColor);
        // 这块没有 return
        Comparator<Apple> byColorLambda = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        // 如果加了{} 花括号就要 return 了
        Comparator<Apple> byColorLambda2 = (o1, o2) -> {return o1.getColor().compareTo(o2.getColor());};

        Function<String, Integer> stringConsumer = s -> s.length();

        // 按以前的理解，就是已经有了一个实现类了，后面就可以用了
        Predicate<Apple> p = a -> a.getColor().equals("green");

        Runnable r = ()->{};

        //一个入参，一个返回值；BiFunction：两个入参，一个返回值
        Function<Apple, Boolean> f = (a) -> "green".equals(a.getColor());

        //get: 拿到一个想要的东西
        Supplier<Apple> s = Apple::new;
        Apple a2 = createApple(() -> new Apple("Green", 100));

    }

    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }
}
