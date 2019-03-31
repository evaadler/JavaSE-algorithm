import java.util.HashSet;
import java.util.Set;

public class 快乐数 {

    public static void main(String[] args) {
        boolean flag = isHappy(19);
        System.out.println(flag);
    }

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        int sum = 0;
        while(!set.contains(sum)){

            sum = getSum(n);
            set.add(sum);

            if (sum ==1){
                return true;
            }
        }

        return false;
    }


    public static int getSum(int n){
        int sum = 0;
        while(n>0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}
