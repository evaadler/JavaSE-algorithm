package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        //////////////
        List<Integer> list2 = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream2 = list2.stream();
        stream2.filter(x -> x > 7).forEach(System.out::println);

        //////////////
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }
}
