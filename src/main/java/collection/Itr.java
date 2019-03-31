package collection;

import java.util.*;

public class Itr implements Iterator {
    protected int limit = 0; //ArrayList.this.size;  // 集合列表的个数尺寸
    int cursor;  // 下一个元素的索引位置
    int lastRet = -1;  // 上一个元素的索引位置
    int modCount = 0;
    int expectedModCount = modCount;

    @Override
    public boolean hasNext() {
        return cursor < limit;
    }

    @Override
    public Object next() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    /*
    public E next() {

        // modCount用于记录ArrayList集合的修改次数，初始化为0，
        // 每当集合被修改一次（结构上面的修改，内部update不算），
        // 如add，remove等方法，modCount+1,所以如果modCount不变，
        // 则表示集合内容没有被修改
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        int i = cursor;
        //如果下一个元素的索引位置超过了集合长度抛出异常
        if (i >= limit)
            throw new NoSuchElementException();
        Object[] elementData = null;// ArrayList.this.elementData;
        if (i >= elementData.length)
            throw new ConcurrentModificationException();
        // 调用一次cursor加一次
        cursor = i + 1;
        // 返回当前一个元素
        return (E) elementData[lastRet + 1];
    }*/

    public void remove() {
        // lastRet每次在remove成功后都需要在next()中重新赋值，
        // 否则调用一次再调用为-1异常，因此使用迭代器的remove方法
        //前必须先调用next()方法
        if (lastRet < 0) {
            throw  new IllegalStateException();
        }
        if (modCount != expectedModCount){
            throw new ConcurrentModificationException();
        }

        try{
           // ArrayList.list.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
            limit--;
        }catch (IndexOutOfBoundsException ex){
            throw new ConcurrentModificationException();
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4};
        List list = Arrays.asList(data);
        System.out.println(list.size());

        Arrays.asList(1,2,3);
    }
}
