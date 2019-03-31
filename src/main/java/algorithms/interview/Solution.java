package algorithms.interview;

import java.util.Scanner;

/**
 * Created by fifi on 2017/7/20.
 */
public class Solution {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();   // n songs
            int s = scanner.nextInt();   // len of song
            int L = scanner.nextInt();   // len of CD
            System.out.println(getNum(n, s, L));
        }
    }

    public static int getNum(int n, int s, int L) {
        int songLen = n * s + (n-1);
        int num = 0;
        if (songLen % L == 0) {
            num = songLen / L;
        }
        return 0;
    }
}
