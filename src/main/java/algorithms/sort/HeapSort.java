package algorithms.sort;

/**
 * 1. 建立大根堆（最大树是root）
 * Created by fifi on 2017/4/9.
 */
public class HeapSort {
    private Comparable[] a;
    private int N = 0;

    public HeapSort(Comparable[] a){
        this.a = a;
        N = a.length;
    }

    public void sort() {
        for (int k = N/2; k >= 1; k--) {
            sink(a, k);
        }
        while (N > 1) {
            exch(1, N--);
            sink(a, 1);
        }
    }

    private void exch(int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 下沉的过程
     * @param a
     * @param k
     */
    private void sink(Comparable[] a, int k) {

        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int j, int i) {
        return a[i].compareTo(a[j]) < 0;
    }


}
