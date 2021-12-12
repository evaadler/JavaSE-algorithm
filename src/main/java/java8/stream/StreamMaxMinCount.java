package java8.stream;

import java.util.*;

/**
 * StreamMaxMinCount
 *
 * @author Alicia
 * @description
 * @date 2021/12/12
 */
public class StreamMaxMinCount {
    public static void main(String[] args) {
        //获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

        /////////获取Integer集合中的最大值。
        List<Integer> listNew = Arrays.asList(7, 6, 9, 4, 11, 6);

// 自然排序
        Optional<Integer> maxNew = listNew.stream().max(Integer::compareTo);
// 自定义排序
        Optional<Integer> max2New = listNew.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + maxNew.get());
        System.out.println("自定义排序的最大值：" + max2New.get());

        ///////////获取员工工资最高的人。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> maxNewNew = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + maxNewNew.get().getSalary());

        ////////计算Integer集合中大于 6 的元素的个数。
        List<Integer> listNewNew = Arrays.asList(7, 6, 4, 8, 2, 11, 9);

        long count = listNewNew.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }
}
