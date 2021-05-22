package datastructure.sort;

import java.util.Arrays;

/**
 * SelectSort
 *
 * @author Alicia
 * @description
 * @date 2021/3/21
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34,119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {


        // 第1轮
        for (int i=0; i<arr.length-1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // 将最小值，放在arr[0]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));
        }
    }
}
