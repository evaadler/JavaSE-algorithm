package datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * QuickSort
 *
 * @author Alicia
 * @description
 * @date 2021/3/28
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {-9,78,0,23,-567, 70};
        int[] arr = new int[8000000];
        for (int i=0; i<8000000; i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str= sdf.format(date1);
        System.out.println("排序前的时间是="+date1Str);
        quickSort(arr, 0, arr.length-1);
        //System.out.println("arr="+ Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str= sdf.format(date2);
        System.out.println("排序后的时间是="+date2Str);
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left; // 左下标
        int r = right; //
        int temp = 0; // 交换使用
        // pivot :中轴
        int pivot = arr[(left + right) / 2];
        // while循环的目的是让比pivot值小的放到
        while (l < r){
            // 在pivot的左边一直找，找到一个大于或者等于pivot的值，才退出
            while (arr[l] < pivot){
                l += 1;
            }
            // 在pivot的右边一直找，找到一个小于或者等于pivot的值，才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            // 说明pivot的左右两边的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于的
            if (l >= r){
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现这个arr[l] == pivot值相等，前移
            if (arr[l] == pivot){
                r -= 1;
            }
            // 如果交换完后，发现这个arr[r] == pivot值相等，后移
            if (arr[r] == pivot){
                l += 1;
            }
        }
        // 如果 l==r, 必须l++, r--, 否则为出现栈溢出
        if (l==r){
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l){
            quickSort(arr, l, right);
        }
    }
}
