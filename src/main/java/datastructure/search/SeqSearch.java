package datastructure.search;

/**
 * SeqSearch
 *
 * @author Alicia
 * @description
 * @date 2021/3/29
 */
public class SeqSearch {
    public static void main(String[] args) {
       int arr[] = {1, 9, 11, -1, 34, 89};
    }

    public static int seqSearch(int[] arr, int value){
        // 线性查找是逐一比对
        for (int i=0; i<arr.length; i++){
            if (arr[i] ==  value){
                return i;
            }
        }
        return -1;
    }
}
