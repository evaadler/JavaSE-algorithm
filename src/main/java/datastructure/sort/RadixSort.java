package datastructure.sort;

import java.util.Arrays;

/**
 * RadixSort
 *
 * @author Alicia
 * @description
 * @date 2021/3/29
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr ={53, 3, 542, 748, 14, 214};
        radixSort(arr);

    }

    public static void radixSort(int[] arr){
        // 第一轮（针对每个元素的个位进行排序处理）

        // 得到数组中最大的数的位数
        int max = arr[0]; // 假设第一数就是最大数
        for (int i=1; i<arr.length; i++ ){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        // 得到最大数是几位数【巧妙】
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        /*
        1. 二维数组包含10个一维数组
        2. 为了防止在放入数的时候数据溢出，则每个一维数组（桶），大小定位arr.length
        3. 明显基数排序是空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的数据个数
        // bucketElementCounts
        int[] bucketElementCounts = new int[10];

        for (int i=0, n=1; i<maxLength; i++, n*=10) {


            //第一轮（针对每个元素的对应的位进行排序处理）个位，十位，百位
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的个位的值
                int digitOfElement = arr[j] /n % 10; //10位的数是 arr[j] /10 % 10
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            // 遍历每一桶，并将桶中数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，则放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
            }


        System.out.println("第"+(i+1)+"轮，对个位的排序处理arr="+ Arrays.toString(arr));
    }}
}
