package algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * largets ranctangle
 * Created by fifi on 2017/4/12.
 */
public class Test {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();  // case number

        Stack<Integer> S = new Stack<>();
        S.push(0);

        int N = scan.nextInt();
        int hs[] = new int[N];
        hs[N-1] = 0;






            long ans = 0;

            for (int n = 1; n <= N; n++) {
                int h = scan.nextInt();  // ranctangle number
                hs[n-1] = h;
                while (h < S.peek()) {
                    int a = hs[n-1];
                    S.pop();
                    int b = n - S.peek() - 1;
                    if (a * b > ans) {
                        ans = (long)a*b;
                    }
                }

            }
        System.out.println(ans);
        scan.nextLine();


    }
}
