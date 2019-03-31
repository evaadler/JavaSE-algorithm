package util;

import java.util.Scanner;

public class ByteUtil {
    public static void main(String[] args) {
        ByteUtil bu = new ByteUtil();
        //Scanner scan = new Scanner(System.in);
       // int n = scan.nextInt();

        System.out.println("The result is " + bu.countFor1(19934318));
    }

    public int countFor1(int number){
        int remainder = 0; // 余数
        int quotient = 1; // 商
        int temp = number;
        int count = 0;

        while (quotient != 0){
            quotient = temp / 2;
            remainder = temp % 2;
            temp = quotient;

            count += remainder;
        }

        return count;
    }

    public int countFor1_2(int number) {
        int n = number;
        int count = 0;
        while (n>0) {
            if ((n&1)>0)
                count++;
            n=n>>1;
        }
        //a&=a-1;//判断二进制有多少个1
        //a|=a-1;//判断二进制有多少个0

        return count;
    }

    // 1. 做除法 ， 如果商>2,继续除，记录余数
    // 2. 判断余数0 or 1
}
