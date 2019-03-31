package algorithms.rate;

/**
 * Created by fifi on 2017/4/23.
 */
public class Mathematics {
    /**
     * 阶乘 n! = n * (n-1) * ... * 2 * 1
     * @return
     */
    public static long factorial(int n){
        long m = 1;
        for (int i=1; i<=n; i++){
           m *= i;
        }
        return m;
    }


    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(int n, int m){
        if(n>m)
            return factorial(n)/factorial(n-m);
        return 0;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     * @param n
     * @param m
     * @return
     */
    public static long combination(int n, int m){
        if(n>m)
            return factorial(n)/(factorial(n-m) * factorial(m));
        return 0;
    }

    /**
     * 求组合数
     * @param n
     * @param m
     * @return
     */
    public static long C(int n, int m){
        return factorial(n)/(factorial(m)*factorial(n-m));
    }

    /**
     * 判断是否是素数
     * 【素数】：只能被1和他自身整除的大于1的数
     * 【谓词】：判断一个事物是否具有某一性质
     * @param n
     * @return
     */
    public static boolean is_prime(int n){
        return false;
    }

    public static void main(String[] args) {
       // System.out.println(C(10,3));
        System.out.println(factorial(3));
    }

}
