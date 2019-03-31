package datastructure.queue;

/**
 * Created by fifi on 2017/5/9.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;  // number of elements on pq


    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i=0; i<N; i++){
            if(less(max, i)) max = i;
        }
        exch(max, N-1);
        return pq[--N];
    }

    private void exch(int max, int i) {
        Key temp = pq[max];
        pq[max] = pq[i];
        pq[i] = temp;
    }

    private boolean less(int max, int i) {
        return max < i;
    }

}
