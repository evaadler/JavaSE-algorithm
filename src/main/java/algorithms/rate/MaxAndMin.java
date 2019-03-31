package algorithms.rate;

import java.util.Arrays;



/**
 * Find the maximum and minimum number in Array
 * Created by fifi on 2017/5/1.
 */
public class MaxAndMin {
    public static void main(String[] args) {

        // normal case testing
        int[] primes = {31, 37, 41, 43, 47, 59};
        System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                Arrays.toString(primes), max(primes), min(primes));
        int[] even = {2, 4, 14, 16, 18, 20};
        System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                Arrays.toString(even), max(even), min(even));
        int[] odd = {1, 3, 11, 15, 18, 21};
        System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                Arrays.toString(odd), max(odd), min(odd));

        // testing for empty array
        try {
            int[] empty = {};
            System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                    Arrays.toString(empty), max(empty), min(empty));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        // testing for array with negative
        int[] negative = {1, -1, 2, -3};
        System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                Arrays.toString(negative), max(negative), min(negative));

        // testing for a single element array
        int[] single = {1};
        System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                Arrays.toString(single), max(single), min(single));

        // testing for a null array
        try {
            int[] nullInput = null;
            System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n",
                    Arrays.toString(nullInput), max(nullInput), min(nullInput));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static int max(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            throw new IllegalArgumentException("Invalid input: " + Arrays.toString(numbers));
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if(numbers[i]>max) max = numbers[i];
        }
        return max;
    }

    private static int min(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            throw new IllegalArgumentException("Invalid input: " + Arrays.toString(numbers));
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if(numbers[i]<min) min = numbers[i];
        }
        return min;
    }
 }
