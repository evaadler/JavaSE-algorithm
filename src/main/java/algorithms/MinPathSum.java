package algorithms;

/**
 * 矩阵最小路径和
 * Created by fifi on 2017/3/29.
 */
public class MinPathSum {
    public int minPathSum1 (int[][] m) {
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;

        // 最小路径
        int[][] dp = new int[row][col];

        dp[0][0] = m[0][0];
        // 计算第一列最短路径和
        for (int i = 1; i < row; i++) {
            dp[i][0]  = dp[i-1][0] + m[i][0];
        }

        // 计算第一行最短路径和赋值给dp
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + m[0][i];

        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];
    }


    /**
     * 经过空间压缩的动态规划
     * @param arr
     * @return
     */
    public int minPathSum2(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int more = Math.max(arr.length, arr.length);
        return 0;
    }

    public  static void main(String[] args) {
       // Scanner scan = new Scanner();
//        scan.
    }
}
