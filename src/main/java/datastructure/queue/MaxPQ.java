package datastructure.queue;

import util.StdIn;
import util.Transaction;

import java.util.Vector;

import static javafx.scene.input.KeyCode.M;

/**
 * Priority Queue
 * Created by fifi on 2017/5/8.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ(int capacity){
        // 使用这么丑陋的类型转换是因为在java中没有泛型数组
        pq = (Key[]) new Comparable[capacity+1];
    }

    /**
     * create a priority queue with a given keys
     * @param a
     */
    public MaxPQ(Key[] a){

    }

    /**
     * insert a key into a priority queue
     * @param v
     */
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    private void swim(int k) {
        while(k>1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void exch(int max, int i) {
        Key temp = pq[max];
        pq[max] = pq[i];
        pq[i] = temp;
    }

    private boolean less(int max, int i) {
        return pq[max].compareTo(pq[i]) < 0;
    }

    /**
     * return and remove the largest key
     * @return
     */
    public Key delMax() {
        return null;

    }

    /**
     * return the largest key
     * @return
     */
    public Key max() {
        return null;
    }

    /**
     * number of entries in the priority queue
     * @return
     */
    public int size() {
        return 0;
    }


}
