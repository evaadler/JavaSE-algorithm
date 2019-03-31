package huawei;

import java.util.Scanner;

/**
 * 求正整数的质数因子
 * 定理： 任意一个正整数都可以拆分成质数因子的乘积
 * Created by fifi on 2017/5/15.
 */
public class Primes {

    public String getResult(long ulDataInput){
        StringBuilder sb = new StringBuilder();
        int idx = 2;
        while (ulDataInput != 1) {
            while (ulDataInput%idx==0){
                    ulDataInput = ulDataInput / idx;
                    sb.append(idx).append(" ");

            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(new Primes().getResult(scan.nextLong()));
    }
}
