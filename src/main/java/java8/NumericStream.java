package java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * NumericStream
 *
 * @author Alicia
 * @description
 * @date 2021/9/2
 */
public class NumericStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6});
        //Integer result = stream.filter(i->i.intValue()>3).reduce(0, Integer::sum);

        IntStream intStream = stream.mapToInt(i->i.intValue());
        intStream.filter(i->i>3).sum();

        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b-> Math.sqrt(a*a + b*b)%1==0)
                .boxed()
                .map(x -> new int[]{a, x, (int)Math.sqrt(a * a+x*x)})
                .forEach(r -> System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));

    }
}
