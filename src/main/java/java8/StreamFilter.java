package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * StreamFilter
 *
 * @author Alicia
 * @description
 * @date 2021/9/2
 */
public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        // 得到偶数
        List<Integer> result = list.stream().filter(i->i%2==0).collect(toList());
        System.out.println(result);

        String[] words = {"Hello", "World"};
        //{h,e,l,l,o},{w,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w->w.split(""));
        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
    }
}
