package datastructure.queue;

/**
 * Created by fifi on 2017/5/10.
 */
public class Heap {
    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k=N/2; k >=1; k--){
            sink(pq, k, N);
        }
        while (N > 1){
            exch(pq, 1, N);
            sink(pq, 1, --N);
        }
    }

    private static void exch(Comparable[] pq, int i, int n) {
    }

    private static void sink(Comparable[] pq, int k, int n) {
    }
}
