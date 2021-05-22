package datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BubbleSort
 *
 * @author Alicia
 * @description
 * @date 2021/3/19
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {3, 9, -1, 10, -2};

        //System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));

        // 测试大数据量 80000
        int[] arr = new int[80000];
        for (int i=0; i<80000; i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str= sdf.format(date1);
        System.out.println("排序前的时间是="+date1Str);

        // 测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str= sdf.format(date2);
        System.out.println("排序后的时间是="+date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));
    }

    // 将前面冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr){
        // 第一趟排序，就是将最大的数排在最后
        int temp = 0;
        boolean flag = false;
        for(int i=0; i< arr.length-1; i++) {

            for (int j = 0; j < arr.length -1-i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true; // 小技巧：Tips 如果进来循环设置为true
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第"+(i+1)+"趟排序后的数组");
            //System.out.println(Arrays.toString(arr));

            if (!flag){ // 在一趟排序中，一次交换都没发生过
                break ;
            }else {
                flag = false; // 重置flag,进行下次判断
            }
        }
    }
}
