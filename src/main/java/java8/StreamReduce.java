package java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * StreamReduce
 * 分片，对立面其中的每个元素都进行操作
 *
 * @author Alicia
 * @description
 * @date 2021/9/2
 */
public class StreamReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);
        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        stream.reduce((i,j)->i+j).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        stream.reduce((i,j)->{
            return i>j?i:j;
        }).ifPresent(System.out::println);
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6});
        stream.reduce(Integer::min).ifPresent(System.out::println);
        stream.reduce((i,j)->i>j?j:i).ifPresent(System.out::println);
    }
}
