package java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TradeTransactonTest
 *
 * @author Alicia
 * @description
 * @date 2020/6/28
 */
public class TradeTransactonTest {

    List<Transaction> transactions;

    @Before
    public void before(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
                );
    }

    // 1。 找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1(){
        transactions.stream()
                .filter(t -> t.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getAmount))
                .forEach(System.out::println);
    }

    // 2。 交易员都在哪些不同的城市工作过
    @Test
    public void test2(){
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                //.map(t->t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
    // 3。 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(e -> "Cambridge".equals(e.getCity()))
                .sorted((e1, e2)->e1.getName().compareTo(e2.getName()))
                .distinct()
                .forEach(System.out::println);

    }

    // 4。 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4(){
        transactions.stream()
                .map(t->t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);

        transactions.stream()
                .map(t->t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
    }

    // 5。 有没有交易员实在米兰工作的？
    @Test
    public void test5(){
        final boolean flag = transactions.stream()
                .map(t -> t.getTrader())
                .anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println(flag);
    }

    // 6。 打印生活在剑桥的交易员的所有总交易额
    @Test
    public void test(){
        final long sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.summarizingInt(t -> t.getAmount()))
                .getSum();
        //.map(Transanction::getAmount)
        //.reduce(Integer::sum)
        System.out.println(sum);

    }
    // 7.  所有交易中，最高的交易额是多少？
    @Test
    public void test7(){
        final Optional<Integer>  max = transactions.stream()
                //. (Collectors.maxBy(Comparator.comparingInt(Transaction::getAmount)))
                //.map(Transaction::getAmount);
                .map(t->t.getAmount())
                .max(Integer::compare);
        System.out.println(max.get());

    }

    // 8. 找到交易额最小的交易
    @Test
    public void test8(){
        final Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()));
        System.out.println(min.get());
    }

}

