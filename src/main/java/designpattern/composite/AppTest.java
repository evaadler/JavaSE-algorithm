package designpattern.composite;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求；制作一个集合，要求该集合能记录曾今加过多少个元素（不是统计某一时刻集合中有多少个元素）
 *
 * @author Alicia
 * @description
 * @date 2021/8/21
 */
public class AppTest {

    public static void main(String[] args) {
        MySet set = new MySet();
        set.add("a");
        set.add("b");
        set.add("c");

        Set set2 = new HashSet();


        System.out.println(set.getCount());
    }
}

/**
 * 修改
 * 用继承的话：问题是如果在新的 jdk 版本中，HashSet 突然多了一个元素加入集合的入口方法：addSome
 */
class MySet extends HashSet {

    private int count = 0;

    @Override
    public boolean add(Object e){
        count++;
        return super.add(e);
    }

    public int getCount(){
        return count;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean bb = false;
        for (Object obj :c){
            if (add(c)){
                bb = true;
            }
        }
        return bb;
    }

}
