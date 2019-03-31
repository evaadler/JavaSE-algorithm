package algorithms;

public class MatrixTest {
    /**
     * 矩阵分圈打印
     * 【思路】左上角和右下角两个点可以表示一个矩阵
     * @param arr
     */
    public void spiralOrderPrint(int[][] arr) {
        int sr = 0;  // 起始点横坐标
        int sc = 0;  // 起始点纵坐标
        int er = arr.length - 1;  // 目标点横坐标
        int ec = arr[0].length - 1;  // 目标点纵坐标
        while(sr<=er && sc<=ec){
            printEdge(arr, sr++, sc++, er--, ec--);
        }
    }

    /**
     * 打印每个子矩阵的一个外层
     */
    public void printEdge(int[][] arr, int tr, int tc, int dr, int dc){
        if (tr == dr) { // 子矩阵只有一行时
            for (int i = tc; i <= tc; i++) {
                System.out.print(arr[tr][i] + " ");
            }
        }else if(tc == dc) { // 子矩阵只有一列时
            for (int i = tr; i <= dr; i++) {
                System.out.print(arr[i][tc] + " ");
            }
        }else { // 一般情况
            int curc = tc;
            int curr = tr;
            while (curc != dc) {
                System.out.print(arr[tr][curc] + " ");
                curc++;
            }
            while (curr != dr) {
                System.out.print(arr[curr][dc] + " ");
                curr++;
            }
            while (curc != tc) {
                System.out.print(arr[dr][curc] + " ");
                curc--;
            }
            while (curr != tr) {
                System.out.print(arr[curr][tc] + " ");
                curr--;
            }
        }
    }

    /**
     * 之字打印矩阵
     * 【思路】行和列一起移动，打印做坐标点确定的斜线上的点，boolean控制打印方向
     * @param arr
     */
    public void printMatrixZigZag(int[][] arr){
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        int endr = arr.length - 1;
        int endc = arr[0].length - 1;

        boolean fromUp = false;

        while (tr != endr + 1) {
            printLevel(arr, tr, tc, dr, dc, fromUp);
            tr = tc == endc ? tr + 1 : tr;
            tc = tc == endc ? tc : tc + 1;
            dc = dr == endr ? dc + 1 : dc;
            dr = dr == endr ? dr : dr + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 打印斜线上的点
     * @param arr
     * @param tr 上坐标
     * @param tc
     * @param dr 下坐标
     * @param dc
     * @param fromUp
     */
    public void printLevel(int[][] arr, int tr, int tc, int dr, int dc, boolean fromUp) {
        if (fromUp) {
                while (tr != dr + 1) {
                System.out.print(arr[tr++][tc--] + " ");
            }
        }else {
            while (dr != tr - 1) {
                System.out.print(arr[dr--][dc++] + " ");
            }
        }

    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new MatrixTest().printMatrixZigZag(arr);
    }
}
