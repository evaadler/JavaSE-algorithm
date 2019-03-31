package util;

import sun.util.resources.cldr.ka.LocaleNames_ka;

import java.util.*;

public class MyHashMap<K,V>{
    private int count = 0;
    private final static int CAPACITY = 16;
    private final static float LOADFACTOR = 0.75f;
    private MyLinkList<K,V>[] array;


    public MyHashMap() {
        this(16);

    }

    public MyHashMap(int len) {
        array = new MyLinkList[len];
    }

    public void put(Object key, Object value){
        if (count>= CAPACITY * LOADFACTOR){
            // resize
        }

        // 1. 通过hash函数确定其插入位置
        int index = hash(key);


        // 避免hashmap中位置冲突
        if(array[index] == null){

            MyLinkList list = new MyLinkList();
            //list.put(key, value);


            array[index] = list;

        }else{

            MyLinkList valueList = array[index];
            //valueList.put(value);

            }
    count++;
    }

    private int hash(Object o) {
        return 0;
    }

    public MyLinkList.MyNode get(K index){


        int idx = hash(index);

        MyLinkList list = array[idx];

        MyLinkList.MyNode node = list.get(idx);

        return node;
    }

    public void transfer(MyLinkList.MyNode[] table, boolean rehash){
        int newCapacity = table.length;
        for (MyLinkList.MyNode e: table){
            while (null != e) {
                MyLinkList.MyNode next = e.next;
                if (rehash) {
                    //e.hash = null == e.key ? 0 : hash(e.key);
                }
              //  int i = indexFor(e.hash, newCapacity);
            //    e.next = table[i];
              //  table[i] = e;
                e = next;
            }
        }
    }


    class MyLinkList<K,V>{
        private MyNode first;
        private int N; // 元素数量

        public boolean isEmpty(){
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void push(MyNode node){
            MyNode oldfirst = first;
            first = node;
            first.next = oldfirst;
            N++;
        }

        public MyNode pop() {
            MyNode item = first.next;
            first = first.next;
            N--;
            return item;
        }

        public MyNode get(int index){
            MyNode node = first;
            int idx = 0;

            while(idx == index) {

                node = node.next;
                idx ++;
                break;
            }
            return node;
        }

        class MyNode<K,V>{
            private K key;
            private V value;
            private MyNode next;
        }

    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();

    }
}
