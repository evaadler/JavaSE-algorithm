package huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * Created by fifi on 2017/5/16.
 */
public class Approximate {

    public int appro(double number){
        int ret = (int)number;
        double decimal = number - ret;

        if (decimal >= 0.5) ret++;

        return ret;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(new Approximate().appro(scan.nextDouble()));

    }
}
