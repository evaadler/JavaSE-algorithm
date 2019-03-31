package algorithms.leetcode;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by fifi on 2017/7/6.
 */
public class ArraySolution {

    public int[] twoSum(int[] numbers, int target){
        // FIXME 思路：将target放入numbers集合中排序，利用二分思想
        /*
        1. numbers拷贝一个新数组
        2 将target放入新数组
        3 排序新数组
        4
         */

        int[] newArr = Arrays.copyOf(numbers, numbers.length+1);
        newArr[numbers.length] = target;
        Arrays.sort(newArr);

        //ArrayList<Integer> list =  new ArrayList<Integer>(Arrays.asList(newArr));
        int tIdx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<newArr.length; i++){

            list.add(i);

            if (target == newArr[i]) tIdx = i;
        }

        int result = 0;

        int[] retArr = new int[2];
        int pre = tIdx - 2;
        int last = tIdx - 1;
        result = newArr[pre] + newArr[last];
        while (result != target && (pre)>=0 && (last)>=0){

            result = newArr[pre] + newArr[last];

            if (pre>0){
                pre--;
            }else{
                last--;
            }



        }

        retArr[0] = pre+1;
        retArr[1] = last+1;
        return retArr;
    }

    public static void main(String[] args) {
        ArraySolution as = new ArraySolution();
        int[] arr = as.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.asList(Arrays.toString(arr)));
    }
}
