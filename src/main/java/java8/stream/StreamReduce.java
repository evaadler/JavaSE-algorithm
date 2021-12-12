package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

        testReduce();
    }

    /**
     * 案例一：求Integer集合的元素之和、乘积和最大值。
     */
    private static void testReduce(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);
    }

    /**
     * 案例二：求所有员工的工资之和和最高工资。
     */
    private static void testReduce2(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }
}
