package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// linkedList 模拟队列
public class LinkedMockQueue {
    private LinkedList link;

    public LinkedMockQueue(){
        link = new LinkedList();
    }

    public void push(Object obj){
        link.addLast(obj);
    }

    public Object pop(){
        return link.removeFirst();  // 队列
        // return link.removeLast();  // 堆栈
    }

    public boolean isEmpty(){
        return link.isEmpty();
    }

    public static void main(String[] args) {
        LinkedMockQueue q = new LinkedMockQueue();

        List l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(3);
        List<Long> ll = q.productExcludeItself(l);
        System.out.println(ll);

    }

    public List<Long> productExcludeItself(List<Integer> nums) {

        // write your code here
        List<Long> rets = new LinkedList<>();

        if(nums.size() == 1 && nums.get(0) == 0) {
            rets.add(0L);
            return rets;
        }

        long sum = 1;

        for (int i : nums) {
            sum *= i;
        }

        for (int i : nums) {
            rets.add(sum / i);
        }

        rets.removeAll();
        return rets;
    }


}
