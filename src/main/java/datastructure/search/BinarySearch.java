package datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * BinarySearch
 *
 * @author Alicia
 * @description
 * @date 2021/3/29
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        int resIndex = binarySearch(arr, 0, arr.length, 1);
    }
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        //
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){ // 向右递归
            return binarySearch(arr, mid+1, right, findVal);
        }else if (findVal < midVal){//向左递归
            return binarySearch(arr, left, mid-1, findVal);
        }else{
            return mid;
        }
    }

    /*
    将所有满足查询值的集合加入到arrayList中
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        //
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){ // 向右递归
            return binarySearch2(arr, mid+1, right, findVal);
        }else if (findVal < midVal){//向左递归
            return binarySearch2(arr, left, mid-1, findVal);
        }else{
            List<Integer> resIndexList = new ArrayList<>();
            // 扫描左边
            int temp = mid -1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                // 否则，就将temp放入到resIndexList
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);

            // 扫描右边
             temp = mid -1;
            while (true){
                if (temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                // 否则，就将temp放入到resIndexList
                resIndexList.add(temp);
                temp += 1;
            }

            return resIndexList;
        }
    }
}
