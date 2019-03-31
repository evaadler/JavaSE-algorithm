package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<>();
        printCollection(listInteger);


        // Part 1
        //List<Object> obj = new ArrayList<Long>();
        //obj.add("I love Android!");

        // Part 2
        Object[] objArray = new Long[1];
        objArray[0] = "I love Android!";
    }

    public static void printCollection(Collection<?> collection) {
        //int t0 = Test.add(10, 20.8);
        int t1 = Test.add(10, 20);
        Number t2 = Test.add(100, 22.2);
        Object t3 = Test.add(121, "abc");

        int t4 = Test.<Integer>add(10,20);
        //int t5 = Test.<Integer>add(100, 22.2);
        Number t6 = Test.<Number>add(121, 22.2);
    }

    public static <T> T add(T x, T y){
        return y;
    }

    public static <T> T get1(T t1, T t2){
        //if (t1.compareTo(t2) >= 0);
        return t1;
    }

    public static <T extends Comparable> T get2(T t1, T t2){
        if (t1.compareTo(t2) >= 0);
        return t1;
    }
}
