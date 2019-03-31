package leetcode;

import java.util.Arrays;

/**
 * Created by fifi on 2017/5/26.
 */
public class Solution {
    public static int hammingDistance(int x, int y) {
        int i = x^y;

        return i;
    }

    public static void main(String[] args) {
        int i = hammingDistance(1,4);
        System.out.println(i);

    }
}
