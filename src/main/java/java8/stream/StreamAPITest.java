package java8.stream;

import java8.Employee;
import java8.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamAPITest
 *
 * @author Alicia
 * @description
 * @date 2020/6/23
 */
public class StreamAPITest {
    List<Employee> employees = EmployeeData.getEmployees();
    @Test
    public void test1() {
        // 1. 可以通过 Collection 系列集合提供的 stream（）或 parallelStream（）
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2. 通过Arrays 中的静态方法 streram() 获取数组流
        Employee[] employees = new Employee[10];
         Stream<Employee> employeeStream   =    Arrays.stream(employees);

         // 3. 通过 Stream 类中的静态方法 of（）
        Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> its = Stream.iterate(0, (x) -> x+2);
        its.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream s = employees.stream()
                .filter(x->x.getAge()>35); //中间操作不会有结果（没有终止操作时，中间操作不执行）
        s.forEach(System.out::println);// 终止操作
    }

    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream()
                .filter(x -> {
                    System.out.println("短路");
                    return x.getSalary()>5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        List<String> strings = Arrays.asList("aa", "bb","cc");
        strings.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        employees.stream()
        .map(Employee::getName);
    }

    @Test
    public void test5(){
        boolean b1 = employees.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);


        // jDk: 把有可能为空的返回值都会封装到Optional中去
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        //Optional.ofNullable(employees.get(0).getCourses())

        Optional<Employee> op1 = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1.get());

        // 公司中最小的工资是多少?
        // 1. 把所有的工资取出来，2。取出最小的
        Optional<Double> op2 = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2);
    }

    /**
     * 规约
     */
    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,100);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x+y);//有起始值，就不会为空，不用返回Optiial
        System.out.println(sum);

        // 公司中工资的总和是多少
        Optional<Double> sumS = employees.stream()
                .map(Employee::getSalary) //拿到所有工资
                //.reduce(0d, (x, y)-> x+y);
                .reduce(Double::sum);
        System.out.println(sumS.get());
    }

    /**
     * 收集
     */
    public void test9(){
        // 把员工的名字提取出来，并放到一个集合中
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test10() {
        // 总数
        Long count = employees.stream()
                .collect(Collectors.counting());

        // 平均值
        employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary) );

        //employees.stream().collect(Collectors.averagingDouble())

        // 总和
        employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        // 最大值(员工)
        Optional<Employee> mx = employees
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        // 最小值（工资）
        Optional<Double> minSalary = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(minSalary.get());
    }

    /**
     * 分组
     */
    @Test
    public void test6(){
       // Map<Employee.Status, List<Employee>> map =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus))
                .forEach((x, y) -> System.out.println(y));
    }

    /**
     * 分区
     */
    @Test
    public void test11(){
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary()>8000));
    }

    public void test12(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }

    public void test13(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "<<<<", ">>>>>"));
    }

    /**
     * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定【1，2，3，4，5】，应该返回【1，4，9，16，25】
     */
    @Test
    public void testPractise(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                .map((n) -> n * n).forEach(System.out::println);
    }

    /**
     * 怎样用map和reduce方法数一数流中有多少个Employee？
     */
    @Test
    public void testPractise2(){
        final Optional<Integer> count = employees.stream()
                .map(e -> 1)
                .reduce(Integer::sum);

        System.out.println(count.get());
    }



    @Test
    public void testPractiseEmployee(){

    }
}
