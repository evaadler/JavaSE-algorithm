package algorithms.sort;

/**
 * Created by fifi on 2017/4/24.
 */
public class MergeSort {
    public void mergeSort(int[] A, int x, int y, int[] T  ){
        int m = x + (y-x)/2;

        int p = x;
        int q = m;
        int i = x;

        mergeSort(A, x, m, T);
        mergeSort(A, m, y, T);

        while (p < m || q < y){
            if(q > y || (p < m && A[p] <= A[q]))
                T[i++] = A[p++];  //
            else
                T[i++] =  A[q++];


        }

        for (i = x; i < y; i++){
            A[i] = T[i];
        }
    }
}
