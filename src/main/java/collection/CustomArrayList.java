package collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList {
    int modCount = 0;
    int DEFAULT_CAPACITY = 10;
    int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    int[] elementData;
    int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;

    //在未指定容量的情况下，容量为 DEFAULT_CAPACITY = 10
    //并且在第一次使用时创建容器数组，在存储过一次数据后，数组的真实容量
    //至少DEFAULT_CAPACITY
    private void ensureCapacityInternal(int minCapacity) {
        // 判断当前的元素容器是否是初始的空数组
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            // 如果是默认的空数组，则minCapacity至少为DEFAULT_CAPACITY
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    // 通过该方法进行真实准确扩容尝试的操作
    private void ensureExplicitCapacity(int minCapacity){
        modCount++;  // 记录List的结构修改的次数
        // 需要扩容
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    // 扩容操作
    private void grow(int minCapacity){
        // 原来的容量
        int oldCapacity = elementData.length;
        // 新的容量 = 原来的容量 + （原来的容量的一半）
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果计算的新的容量比指定的扩容容量小，那么就使用指定的容量
        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        // 如果新的容量大于 MAX_ARRAY_SIZE(Integer.MAX_VALUE-8)
        // 那么就使用hugeCapacity进行容量分配
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }

        // 创建长度为newCapacity 的数组，并复制原来的元素到新的容器，完成ArrayList的扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public  void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("android");
        list.add("android");
        list.add("c");
        list.add("c++");
        list.add("c");
    }

    public void remove1(ArrayList<String> list) {
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            if (s.equals("android")) {
                list.remove(s);
            }
        }
    }

    public void remove2(ArrayList<String> list) {
        for (String s : list) {
            if (s.equals("android")){
                list.remove(s);
            }
        }
    }

    public void remove3(ArrayList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.remove();
        }
    }

    public void remove4(ArrayList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            it.remove();
        }
    }

}
