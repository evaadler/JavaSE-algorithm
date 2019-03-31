package algorithms.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by fifi on 2017/7/20.
 */
public class Sum2 {
    public static void main(String[] args) {
        Sum2 s = new Sum2();
        //int[] arr = {0,3,4,0};
        //int[] arr = {111,222,111,111,222,343,90,90,111,111,111,0,111};
        int[] arr={7,9,4,5};
         int num = Sum2.median(arr);
        System.out.println(num);

    }

    public static int median(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        // write your code here
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];
    }

    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code


        int count = 0;
        int last = nums.get(0);
        Collections.sort(nums);

        // int mid = nums.get(0) + (nums.get(nums.size()-1)-nums.get(0))/2;
        int midIdx = 1 + (nums.size()-1)/2;

        for (int i=0; i<nums.size(); i++){
            if (last != nums.get(0)){
                count = 0;
            }else{
                ++count;
            }

            if(count>=midIdx){
                return nums.get(i);
            }
        }

        return 0;

    }

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int index1 = 0;
        int index2 = 0;
        ArrayList list = new ArrayList();


        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }

        for(int i=0; i<numbers.length; i++) {
            index1 = i;
            int num2 = target - numbers[i];
            if(list.indexOf(num2)!=-1){
                index2 = list.indexOf(num2);
                if(index2 == index1){
                    index2 = list.lastIndexOf(num2);
                }
                break;
            }
        }

        int[] result = new int[2];
        result[0] = index1+1;
        result[1] = index2+1;
        return result;
    }
}
