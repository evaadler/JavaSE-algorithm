package datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ShellSort
 *
 * @author Alicia
 * @description
 * @date 2021/3/22
 */
public class ShellSort {

    public static void main(String[] args) {
        //int[] arr = {8,9,1,7,2,3,5,4,6,0};
        int[] arr = new int[8000000];
        for (int i=0; i<8000000; i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str= sdf.format(date1);
        System.out.println("排序前的时间是="+date1Str);
        shellSort2(arr);

        Date date2 = new Date();
        String date2Str= sdf.format(date2);
        System.out.println("排序后的时间是="+date2Str);
    }

    // 使用逐步推导的方式编写希尔排序
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap>0; gap /=2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }

            }

           // System.out.println("希尔排序第"+(++count)+"轮=" + Arrays.toString(arr));
        }
    }

    // 使用移位法希尔排序
    public static void shellSort2(int[] arr){
        int count = 0;
        // 增量gap，并逐步的缩小增量
        for (int gap = arr.length / 2; gap>0; gap /=2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出 while 后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }

             //System.out.println("希尔排序第"+(++count)+"轮=" + Arrays.toString(arr));
        }
    }
}
