package algorithms.lintcode;

import java.util.Stack;

/**
 * Created by fifi on 2017/7/18.
 */
public class OtherSolution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        //注意 边界条件的处理
        for (int i = 0; i <= heights.length; i++){
            int curr = (i == heights.length) ? 0: heights[i];
            // 注意  count 和 heights[pos] = curr
            int count = 0;
            while(!stack.isEmpty() && heights[stack.peek()] > curr){
                int pos = stack.pop();
                max = Math.max(max, heights[pos] * (i - pos));
                heights[pos] = curr;
                count++;
            }
            i -= count;
            stack.push(i);
        }

        return max;
    }


    /**
     * 阶乘
     * 但这种方法输入50会溢出，所以大数据运算该怎么办？===》1.0
     * @return
     */
    public int jiecheng(int number) {
        int sum  = 1;
        for (int i=number; i>0; i--){
            sum *= i;
        }
        return sum;
    }

    /**
     * 大数据运算：采用数组实现
     */
    public void bigData() {

    }

    public static void main(String[] args) {
        OtherSolution os = new OtherSolution();
       // int[] heights = {2,1,5,6,2,3};
       // int max = os.largestRectangleArea(heights);

        int jiecheng = os.jiecheng(50);
        System.out.println(jiecheng);
    }
}
