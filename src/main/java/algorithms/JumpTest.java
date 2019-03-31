package algorithms;

/**
 * 跳跃问题
 * Created by fifi on 2017/3/29.
 */
public class JumpTest {

    public static int jump(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int jump = 0;
        int cur = 0;
        int next = 0;

        for(int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump ++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }

        return jump;
    }

    public static void main(String[] args) {

        System.out.println("ddd");

        int[] arr = {3,2,3,1,1,4};

        System.out.println(jump(arr));
    }
}
